package com.susanto.beans;

import java.net.InetAddress;

import java.net.UnknownHostException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPoll;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelDashboard;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichActiveOutputText;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.datatransfer.DataFlavor;
import oracle.adf.view.rich.datatransfer.Transferable;
import oracle.adf.view.rich.dnd.DnDAction;
import oracle.adf.view.rich.dnd.DragSource;
import oracle.adf.view.rich.event.ClientListenerSet;
import oracle.adf.view.rich.event.DropEvent;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.change.ChangeManager;
import org.apache.myfaces.trinidad.change.ReorderChildrenComponentChange;
import org.apache.myfaces.trinidad.context.RequestContext;

import org.apache.myfaces.trinidad.event.PollEvent;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AdminBean {
    private RichPanelDashboard dandPNLDB;
    private RichImage recycleBinding;
    String drill;
    int dGCount = 0;
    int count = 0;
    String dGComponent;
    int dPCount = 0;
    String dPComponent;
    private RichInputText materialId;
    private RichPopup savePopupBinding;
    private String popUpMsg = "";
    private String popUpHrd = "";
    private String material_id = null;
    private RichActiveOutputText userName;
    ArrayList<String> allMachines = new ArrayList<String>();
    private String createdRefId3 = null;
    private String urlValue = null;
    private String newFinalUrl = null;
    private String newUrlValue = "10.170.22.50";
    private ResourceBundle adminBundle =
        ResourceBundle.getBundle("view.viewcontrollerBundle",
                                 FacesContext.getCurrentInstance().getViewRoot().getLocale());
    private RichPoll pollListenerRecycleBinBinding;
    private RichPanelGroupLayout pglPollListenerContainerBinding;

    public AdminBean() {
        BindingContext ctx = BindingContext.getCurrent();
        DCBindingContainer bc = (DCBindingContainer) ctx.getCurrentBindingsEntry();
        DCIteratorBinding iterator = bc.findIteratorBinding("DnsVO1Iterator");
        ViewObject dnsView = iterator.getViewObject();
        dnsView.executeQuery();
        Row r = iterator.getCurrentRow();
        urlValue = (String) r.getAttribute("Url");
        newFinalUrl = "http://" + urlValue + ":7077";
    }


    public DnDAction handleDnd(DropEvent dropEvent) {
        Transferable dropTransferable = dropEvent.getTransferable();
        UIComponent dropComponent = dropEvent.getDropComponent(); // canvas
        UIComponent movedComponent = dropTransferable.getData(DataFlavor.UICOMPONENT_FLAVOR);
        UIComponent componentToAdd = null;
        boolean isMove;
        isMove = movedComponent.getParent().equals(dropComponent);
        if (!isMove)
            componentToAdd = buildComponent(movedComponent);
        else
            componentToAdd = movedComponent;
        ClientListenerSet clientListenerSet = new ClientListenerSet();
        clientListenerSet.addBehavior("new AdfInitializationBehavior('component.setDragSource(new AdfComponentDragSource())')");
        DragSource ds = new DragSource(DnDAction.MOVE_ONLY);
        componentToAdd.getAttributes().put("_dragSource", ds);
        ((RichPanelGroupLayout) componentToAdd).setClientListeners(clientListenerSet);
        if (isMove)
            dropComponent.getChildren().remove(componentToAdd);
        dropComponent.getChildren().add(dropEvent.getDropSiteIndex(), componentToAdd);
        AdfFacesContext.getCurrentInstance().addPartialTarget(dropComponent);
        return DnDAction.NONE;
    }

    public DnDAction handleContainerDrag(DropEvent dropEvent) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        Transferable transferable = dropEvent.getTransferable();
        UIComponent dragComponent = null;
        dragComponent = transferable.getData(DataFlavor.UICOMPONENT_FLAVOR);
        UIComponent dropComponent = dropEvent.getDropComponent();
        UIComponent dropComponentParent = dropComponent.getParent();
        if (dragComponent != null && dragComponent != dropComponent) {
            List<String> reorderedComponentList = new ArrayList<String>(dropComponentParent.getChildCount());
            for (UIComponent currComponent : dropComponentParent.getChildren()) {
                String currComponentId = currComponent.getId();
                if (!currComponentId.equals(dragComponent.getId())) {
                    reorderedComponentList.add(currComponentId);
                    if (currComponentId.equals(dropComponent.getId())) {
                        reorderedComponentList.add(dragComponent.getId());
                    }
                }
                if (currComponentId.equals(dragComponent.getId())) {
                    dGCount = count;
                    dGComponent = dragComponent.getId();
                }
                if (currComponentId.equals(dropComponent.getId())) {
                    dPCount = count;
                    dPComponent = dropComponent.getId();
                }
                count++;
            }
            if (dGCount > dPCount) {
                Collections.swap(reorderedComponentList, dPCount, dPCount + 1);
            }
            ReorderChildrenComponentChange reorderedChildChange =
                new ReorderChildrenComponentChange(reorderedComponentList);
            reorderedChildChange.changeComponent(dropComponentParent);
            ChangeManager cm = null;
            cm = RequestContext.getCurrentInstance().getChangeManager();
            cm.addComponentChange(fctx, dropComponentParent, reorderedChildChange);
            AdfFacesContext adfFacesCtx = AdfFacesContext.getCurrentInstance();
            adfFacesCtx.addPartialTarget(dropComponentParent);
            return DnDAction.MOVE;
        }
        return DnDAction.NONE;
    }

    public DnDAction deleteHandler(DropEvent dropEvent) {
        this.pollListenerRecycleBinBinding.setRendered(true);
        Transferable transferable = dropEvent.getTransferable();
        UIComponent dragComponent = null;
        dragComponent = transferable.getData(DataFlavor.UICOMPONENT_FLAVOR);
        List<UIComponent> addedComponents = dandPNLDB.getChildren();
        ArrayList<String> al = new ArrayList<String>();
        for (UIComponent uicomponent : addedComponents) {
            String componentId = uicomponent.getId().toString();
            al.add(componentId);
        }
        for (UIComponent uicomponent : addedComponents) {
            if (dragComponent.getId().equalsIgnoreCase("drill01")) {
                int aa = al.indexOf("drill01");
                addedComponents.remove(aa);
                recycleBinding.setSource("/images/recycle_filled.png");
                //this.pollListenerRecycleBinBinding.setRendered(true);
            } else if (dragComponent.getId().equalsIgnoreCase("turn01")) {
                int aa = al.indexOf("turn01");
                addedComponents.remove(aa);
                recycleBinding.setSource("/images/recycle_filled.png");
                //                this.pollListenerRecycleBinBinding.setRendered(true);
            } else if (dragComponent.getId().equalsIgnoreCase("paint01")) {
                int aa = al.indexOf("paint01");
                addedComponents.remove(aa);
                recycleBinding.setSource("/images/recycle_filled.png");
            } else if (dragComponent.getId().equalsIgnoreCase("label01")) {
                int aa = al.indexOf("label01");
                addedComponents.remove(aa);
                recycleBinding.setSource("/images/recycle_filled.png");
            } else if (dragComponent.getId().equalsIgnoreCase("pkg01")) {
                int aa = al.indexOf("pkg01");
                addedComponents.remove(aa);
                recycleBinding.setSource("/images/recycle_filled.png");
            } else if (dragComponent.getId().equalsIgnoreCase("arrow1")) {
                int aa = al.indexOf("arrow1");
                addedComponents.remove(aa);
                recycleBinding.setSource("/images/recycle_filled.png");
            } else if (dragComponent.getId().equalsIgnoreCase("arrow2")) {
                int aa = al.indexOf("arrow2");
                addedComponents.remove(aa);
                recycleBinding.setSource("/images/recycle_filled.png");
            } else if (dragComponent.getId().equalsIgnoreCase("arrow3")) {
                int aa = al.indexOf("arrow3");
                addedComponents.remove(aa);
                recycleBinding.setSource("/images/recycle_filled.png");
            } else if (dragComponent.getId().equalsIgnoreCase("arrow4")) {
                int aa = al.indexOf("arrow4");
                addedComponents.remove(aa);
                recycleBinding.setSource("/images/recycle_filled.png");
            } else if (dragComponent.getId().equalsIgnoreCase("arrow5")) {
                int aa = al.indexOf("arrow5");
                addedComponents.remove(aa);
                recycleBinding.setSource("/images/recycle_filled.png");
            }
            break;
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(pglPollListenerContainerBinding);
        AdfFacesContext.getCurrentInstance().addPartialTarget(recycleBinding);
        AdfFacesContext.getCurrentInstance().addPartialTarget(dandPNLDB);
        return DnDAction.NONE;
    }

    public void pollListenerRecycleBin(PollEvent pollEvent) {
        recycleBinding.setSource("/images/recycle_empty.png");
        AdfFacesContext.getCurrentInstance().addPartialTarget(recycleBinding);
        this.pollListenerRecycleBinBinding.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(pglPollListenerContainerBinding);
    }

    public void setRecycleBinding(RichImage recycleBinding) {
        this.recycleBinding = recycleBinding;
    }

    public RichImage getRecycleBinding() {
        return recycleBinding;
    }

    private UIComponent buildComponent(UIComponent movedComponent) {
        UIComponent componentToAdd = null;
        if (movedComponent instanceof RichCommandButton) {
            int childrenCount = this.getDandPNLDB().getChildCount();
            List<UIComponent> presentComponents = dandPNLDB.getChildren();
            ArrayList<String> al = new ArrayList<String>();
            for (UIComponent uicomponent : presentComponents) {
                String componentId = uicomponent.getId().toString();
                al.add(componentId);
            }
            if (movedComponent.getId().equals("cb11")) {
                if (al.contains("drill01")) {
                    FacesMessage infoMessage = new FacesMessage("Drilling Machine is already in the workflow");
                    infoMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext.getCurrentInstance().addMessage(null, infoMessage);
                } else {
                    //                    RichImage cb1 = new RichImage();
                    //                    cb1.setId("arr1");
                    //                    cb1.setSource("/images/forwardArrow.png");
                    //                    componentToAdd = cb1;
                    RichCommandButton cb = new RichCommandButton();
                    drill = cb.getId();
                    cb.setId("d001");
                    cb.setInlineStyle("height:80px; width:80px; text-align:center; border-radius:50%;border-left-style:solid; border-left-width:2px; border-left-color:Olive; border-right-color:Olive; border-right-style:solid; border-right-width:2px; border-top-color:Olive; border-top-style:solid; border-top-width:2px; border-bottom-color:Olive; border-bottom-style:solid; border-bottom-width:2px;");
                    cb.setIcon("/images/drillingIcon.png");
                    componentToAdd = cb;
                }
            }
            if (movedComponent.getId().equals("cb12")) {
                if (al.contains("turn01")) {
                    FacesMessage infoMessage = new FacesMessage("Turning Machine is already in the workflow");
                    infoMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext.getCurrentInstance().addMessage(null, infoMessage);
                } else {
                    RichCommandButton cb = new RichCommandButton();
                    cb.setId("t001");
                    cb.setInlineStyle("height:80px; width:80px; text-align:center; border-radius:50%;border-left-style:solid; border-left-width:2px; border-left-color:Olive; border-right-color:Olive; border-right-style:solid; border-right-width:2px; border-top-color:Olive; border-top-style:solid; border-top-width:2px; border-bottom-color:Olive; border-bottom-style:solid; border-bottom-width:2px;");
                    cb.setIcon("/images/turnIcn.png");
                    componentToAdd = cb;
                }
            }
            if (movedComponent.getId().equals("cb13")) {
                if (al.contains("paint01")) {
                    FacesMessage infoMessage = new FacesMessage("Painting Machine is already in the workflow");
                    infoMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext.getCurrentInstance().addMessage(null, infoMessage);
                } else {
                    RichCommandButton cb = new RichCommandButton();
                    cb.setId("p001");
                    cb.setInlineStyle("height:80px; width:80px; text-align:center; border-radius:50%;border-left-style:solid; border-left-width:2px; border-left-color:Olive; border-right-color:Olive; border-right-style:solid; border-right-width:2px; border-top-color:Olive; border-top-style:solid; border-top-width:2px; border-bottom-color:Olive; border-bottom-style:solid; border-bottom-width:2px;");
                    cb.setIcon("/images/Painting.png");
                    componentToAdd = cb;
                }
            }
            if (movedComponent.getId().equals("cb14")) {
                if (al.contains("label01")) {
                    FacesMessage infoMessage = new FacesMessage("Labellling Machine is already in the workflow");
                    infoMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext.getCurrentInstance().addMessage(null, infoMessage);
                } else {
                    RichCommandButton cb = new RichCommandButton();
                    cb.setId("l001");
                    cb.setInlineStyle("height:80px; width:80px; text-align:center; border-radius:50%;border-left-style:solid; border-left-width:2px; border-left-color:Olive; border-right-color:Olive; border-right-style:solid; border-right-width:2px; border-top-color:Olive; border-top-style:solid; border-top-width:2px; border-bottom-color:Olive; border-bottom-style:solid; border-bottom-width:2px;");
                    cb.setIcon("/images/labelling.png");
                    componentToAdd = cb;
                }
            }
            if (movedComponent.getId().equals("cb15")) {
                if (al.contains("pkg01")) {
                    FacesMessage infoMessage = new FacesMessage("Packaging Machine is already in the workflow");
                    infoMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext.getCurrentInstance().addMessage(null, infoMessage);
                } else {
                    RichCommandButton cb = new RichCommandButton();
                    cb.setId("pg001");
                    cb.setInlineStyle("height:80px; width:80px; text-align:center; border-radius:50%;border-left-style:solid; border-left-width:2px; border-left-color:Olive; border-right-color:Olive; border-right-style:solid; border-right-width:2px; border-top-color:Olive; border-top-style:solid; border-top-width:2px; border-bottom-color:Olive; border-bottom-style:solid; border-bottom-width:2px;");
                    cb.setIcon("/images/package.png");
                    componentToAdd = cb;
                }
            }
            if (movedComponent.getId().equals("cb16")) {
                if (al.contains("arrow1") && al.contains("arrow2") && al.contains("arrow3") && al.contains("arrow4") &&
                    al.contains("arrow5")) {
                    FacesMessage infoMessage = new FacesMessage("Cannot add more navigation component");
                    infoMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext.getCurrentInstance().addMessage(null, infoMessage);
                } else {
                    int noofarr = 1;
                    int i;
                    int childCount = this.getDandPNLDB().getChildCount();
                    List<UIComponent> containing = dandPNLDB.getChildren();
                    ArrayList<String> all = new ArrayList<String>();
                    for (UIComponent uicomponent : presentComponents) {
                        String componentId = uicomponent.getId().toString();
                        all.add(componentId);
                    }
                    if (all.contains("drill01"))
                        all.remove("drill01");
                    if (all.contains("turn01"))
                        all.remove("turn01");
                    if (all.contains("paint01"))
                        all.remove("paint01");
                    if (all.contains("label01"))
                        all.remove("label01");
                    if (all.contains("pkg01"))
                        all.remove("pkg01");
                    for (i = 0; i < all.size(); ++i) {
                        if (all.get(i).contains("arr")) {
                        }
                    }
                    noofarr = noofarr + i;
                    RichImage cb = new RichImage();
                    cb.setId("arr" + noofarr);
                    cb.setSource("/images/forwardArrow.png");
                    componentToAdd = cb;
                }
            }

        }
        RichPanelGroupLayout pgl = new RichPanelGroupLayout();

        if (componentToAdd.getId().equals("d001")) {
            pgl.setId("drill01");
        }
        if (componentToAdd.getId().equals("t001"))
            pgl.setId("turn01");
        if (componentToAdd.getId().equals("p001"))
            pgl.setId("paint01");
        if (componentToAdd.getId().equals("l001"))
            pgl.setId("label01");
        if (componentToAdd.getId().equals("pg001"))
            pgl.setId("pkg01");
        if (componentToAdd.getId().equals("arr1")) {
            pgl.setId("arrow1");
        }
        if (componentToAdd.getId().equals("arr2")) {
            pgl.setId("arrow2");
        }
        if (componentToAdd.getId().equals("arr3"))
            pgl.setId("arrow3");
        if (componentToAdd.getId().equals("arr4"))
            pgl.setId("arrow4");
        if (componentToAdd.getId().equals("arr5"))
            pgl.setId("arrow5");
        pgl.getChildren().add(componentToAdd);
        return pgl;
    }


    public void saveWorkflow(ActionEvent actionEvent) throws ParseException {
        if (materialId.getValue() == null) {
            setPopUpMsg(adminBundle.getString("materialId"));
            setPopUpHrd(adminBundle.getString("ERROR"));
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            this.getSavePopupBinding().show(hints);

        } else {
            String user_name = userName.getValue();
            material_id = (String) materialId.getValue();
            RichPanelDashboard PF = getDandPNLDB();
            List<UIComponent> listcomp = PF.getChildren();
            Iterator iter = listcomp.iterator();
            while (iter.hasNext()) {
                UIComponent comp = (UIComponent) iter.next();
                if (comp.getId().equals("drill01"))
                    allMachines.add("Drilling");
                else if (comp.getId().equals("turn01"))
                    allMachines.add("Turning");
                else if (comp.getId().equals("paint01"))
                    allMachines.add("Painting");
                else if (comp.getId().equals("label01"))
                    allMachines.add("Labelling");
                else if (comp.getId().equals("pkg01"))
                    allMachines.add("Packaging");
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < allMachines.size(); i++) {
                allMachines.get(i);
                stringBuffer.append(allMachines.get(i)).append(",");
            }
            String newFlowPattern = stringBuffer.toString();
            newFlowPattern = "flowpattern=" + newFlowPattern.substring(0, newFlowPattern.length() - 1).toUpperCase();
            String unameUpper = user_name.toUpperCase();
            String username = "userid=" + unameUpper;
            String matIdUpper = material_id.toUpperCase();
            String mat_id = "materialid=" + matIdUpper;
            String finalString = username + "&" + newFlowPattern + "&" + mat_id;
            String jsonObject1 = finalString;
            HttpRestClient httpRestClient = new HttpRestClient();
            //httpRestClient.connectToServer(newFinalUrl + "/callesbservice", "saveworkflow");
            httpRestClient.connectToServer(newFinalUrl + "/callesbservice", "save_wf_metd_param");
            //httpRestClient.connectToServer("http://" + urlValue + ":8088/callesbservice", "saveworkflow");
            String jsonString = httpRestClient.sendPOSTRequest(jsonObject1);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            String createdRefId1 = (String) jsonObject.get("status");

            String createdRefId2 = createdRefId1.substring(52);

            //createdRefId3 = createdRefId2.substring(0, createdRefId2.indexOf(" "));
            // String patternMsg = "Saved Successfully! The Rfid for " + mat_id + " is " + createdRefId2;
            String patternMsg = "Saved Successfully!";
            setPopUpMsg(patternMsg);
            setPopUpHrd(adminBundle.getString("INFORMATION"));
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            getSavePopupBinding().show(hints);
        }
    }

    public void setMaterialId(RichInputText materialId) {
        this.materialId = materialId;
    }

    public RichInputText getMaterialId() {
        return materialId;
    }

    public void setSavePopupBinding(RichPopup savePopupBinding) {
        this.savePopupBinding = savePopupBinding;
    }

    public RichPopup getSavePopupBinding() {
        return savePopupBinding;
    }

    public void setUserName(RichActiveOutputText userName) {
        this.userName = userName;
    }

    public RichActiveOutputText getUserName() {
        return userName;
    }

    public void setCreatedRefId3(String createdRefId3) {
        this.createdRefId3 = createdRefId3;
    }

    public String getCreatedRefId3() {
        return createdRefId3;
    }

    public void setPopUpHrd(String popUpHrd) {
        this.popUpHrd = popUpHrd;
    }

    public String getPopUpHrd() {
        return popUpHrd;
    }

    public void setPopUpMsg(String popUpMsg) {
        this.popUpMsg = popUpMsg;
    }

    public String getPopUpMsg() {
        return popUpMsg;
    }

    public void setDandPNLDB(RichPanelDashboard dandPNLDB) {
        this.dandPNLDB = dandPNLDB;
    }

    public RichPanelDashboard getDandPNLDB() {
        return dandPNLDB;
    }

    public void englishLanguage(ActionEvent actionEvent) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
    }

    public void deutschLanguage(ActionEvent actionEvent) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.GERMAN);
    }


    public void setPollListenerRecycleBinBinding(RichPoll pollListenerRecycleBinBinding) {
        this.pollListenerRecycleBinBinding = pollListenerRecycleBinBinding;
    }

    public RichPoll getPollListenerRecycleBinBinding() {
        return pollListenerRecycleBinBinding;
    }

    public void setPglPollListenerContainerBinding(RichPanelGroupLayout pglPollListenerContainerBinding) {
        this.pglPollListenerContainerBinding = pglPollListenerContainerBinding;
    }

    public RichPanelGroupLayout getPglPollListenerContainerBinding() {
        return pglPollListenerContainerBinding;
    }


}
