package com.susanto.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.el.ELContext;

import javax.el.ExpressionFactory;

import javax.el.MethodExpression;
import javax.el.ValueExpression;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;

import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichLink;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.dnd.DnDAction;
import oracle.adf.view.rich.event.ClientListenerSet;
import oracle.adf.view.rich.event.DropEvent;

import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.change.ChangeManager;
import org.apache.myfaces.trinidad.change.ReorderChildrenComponentChange;
import org.apache.myfaces.trinidad.context.RequestContext;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MachineActionBean {

    private RichGridCell gc15Binding;
    private RichGridCell gc16Binding;
    private RichGridCell gc17Binding;
    private RichGridCell gc18Binding;
    private RichGridCell gc19Binding;
    List<String> reorderedComponentList = new ArrayList<String>();
    List<String> drillMethods = new ArrayList<String>();
    List<String> methodParameter = new ArrayList<String>();
    List<String> methodParamTurning = new ArrayList<String>();
    List<String> methodParamPainting = new ArrayList<String>();
    List<String> methodParamLabelling = new ArrayList<String>();
    List<String> methodParamPackaging = new ArrayList<String>();
    private int i = 0;
    private String newUrlValue = "10.170.22.50";
    private String numberOfParts = "0";
    private RichInputText refIdBinding;
    String mat_id_new = null;
    private String workFlowId = null;
    private String ref_IdS12 = null;

    String machines[] = null;
    private String methods[] = null;
    String allMethodsName[] = null;
    private RichPanelGroupLayout pgridContainerBinding;
    private RichGridCell gc20Binding;
    private RichPopup rfIdPopupBinding;

    private RichInputText param1Binding;
    private RichInputText param2Binding;
    private RichPopup showMetParPopBinding;
    private RichCommandButton drillCmdBtnBinding;
    private String machineName = null;
    private String selectMethodName = null;
    private String selectTurnMethodName = null;
    private String selectPackMethodName = null;
    private String selectLabelMethodName = null;
    private String selectPaintMethodName = null;
    private String attributename = null;
    private String machinename = null;
    private String machineNameTurn = null;
    private String machineNameLabel = null;
    private String machineNamePaint = null;
    private String machineNamePack = null;
    private RichPopup showMetParPopBindTurn;
    private RichInputText methNameBindTurn;
    private RichInputText param1BindTurn;
    private RichInputText param2BindTurn;
    private RichCommandButton turnCmdBtnBinding;
    private RichPopup showMetParPopBindPaint;
    private RichInputText methNameBindPaint;
    private RichInputText param1BindPaint;
    private RichInputText param2BindPaint;
    private RichCommandButton paintCmdBtnBinding;
    private RichCommandButton labelCmdBtnBinding;
    private RichInputText methNameBindLabel;
    private RichInputText param1BindLabel;
    private RichInputText param2BindLabel;
    private RichPopup showMetParPopBindLabel;
    private RichCommandButton packCmdBtnBinding;
    private RichPopup showMetParPopBindPack;
    private RichInputText methNameBindPack;
    private RichInputText param1BindPack;
    private RichInputText param2BindPack;
    String urlValue = null;
    private String newFinalUrl = null;
    private RichSelectOneChoice matIDDropDownBinding;
    private RichSelectOneChoice methNameSOCBinding;
    private RichSelectOneChoice turnMethNameSOCBinding;
    private RichSelectOneChoice paintMethNameSOCBinding;
    private RichSelectOneChoice labelMethNameSOCBinding;
    private RichSelectOneChoice packMethNameSOCBinding;
    String drillMachMethParam = null;
    String turnMachMethParam = null;
    String paintMachMethParam = null;
    String labelMachMethParam = null;
    String packMachMethParam = null;
    private RichPopup showAllMethBinding;
    private RichPanelFormLayout testBinding;

    public String methodName1 = "";
    public String methodName2 = "";
    public String methodName3 = "";
    public String methodName4 = "";
    public String methodName5 = "";
    public String methodName6 = "";
    public String methodName7 = "";
    public String methodName8 = "";
    public String methodName9 = "";
    public String methodName10 = "";
    public String parentMethod = "";
    public String headingMethodPopup = "";

    public String method1Desciption = "";
    public String method2Desciption = "";
    public String method3Desciption = "";
    public String method4Desciption = "";
    public String method5Desciption = "";
    public String method6Desciption = "";
    public String method7Desciption = "";
    public String method8Desciption = "";
    public String method9Desciption = "";
    public String method10Desciption = "";
    public String titleMethodDesc = "";

    private ResourceBundle myBundle =
        ResourceBundle.getBundle("view.viewcontrollerBundle",
                                 FacesContext.getCurrentInstance().getViewRoot().getLocale());
    private RichPopup showAllMethodNamesBinding;
    private RichPopup methodDescriptionPopupBinding;
    private RichPanelGroupLayout pglMethodNameBindings;
    private RichButton saveWorkflowButtonBinding;
    private RichDialog showAllMethDialogBinding;
    private RichPopup saveWorkFlowPopupBinding;
    private RichPopup selectMethodNamePopupBinding;

    List<String> allAddedDrillTempMethods = new ArrayList<String>();
    List<String> allAddedTurningMethods = new ArrayList<String>();
    List<String> allAddedPaintingMethods = new ArrayList<String>();
    List<String> allAddedLabellingMethods = new ArrayList<String>();
    List<String> allAddedPackagingMethods = new ArrayList<String>();


    public void showMethodDescription(ClientEvent clientEvent) {
        String methodNameId = clientEvent.getComponent().getId();

        if (methodNameId.equalsIgnoreCase("ot5")) {
            String methodNameValue = clientEvent.getComponent().getAttributes().get("methodName1").toString();

            if (methodNameValue.equalsIgnoreCase("1. drillingTemperature1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_DRILLTEMP1_DESC"));
                setMethod1Desciption(myBundle.getString("DRILLINGTEMPERATURE1_DESCRIPTION"));
            } else if (methodNameValue.equalsIgnoreCase("1. drillingHumidity1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_DRILLHUMI1_DESC"));
                setMethod1Desciption(myBundle.getString("DRILLINGHUMIDITY1_DESCRIPTION"));
            } else if (methodNameValue.equalsIgnoreCase("1. drillingPressure1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_DRILLPRESS1_DESC"));
                setMethod1Desciption(myBundle.getString("DRILLINGPRESSURE1_DESCRIPTION"));
            }
        } else if (methodNameId.equalsIgnoreCase("ot6")) {
            String methodName2Value = clientEvent.getComponent().getAttributes().get("methodName2").toString();

            if (methodName2Value.equalsIgnoreCase("2. drillingTemperature2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_DRILLTEMP2_DESC"));
                setMethod1Desciption(myBundle.getString("DRILLINGTEMPERATURE2_DESCRIPTION"));
            } else if (methodName2Value.equalsIgnoreCase("2. drillingHumidity2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_DRILLHUMI2_DESC"));
                setMethod1Desciption(myBundle.getString("DRILLINGHUMIDITY2_DESCRIPTION"));
            } else if (methodName2Value.equalsIgnoreCase("2. drillingPressure2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_DRILLPRESS2_DESC"));
                setMethod1Desciption(myBundle.getString("DRILLINGPRESSURE2_DESCRIPTION"));
            }
        } else if (methodNameId.equalsIgnoreCase("ot7")) {
            String methodName3Value = clientEvent.getComponent().getAttributes().get("methodName3").toString();

            if (methodName3Value.equalsIgnoreCase("3. turningTemperature1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_TURNTEMP1_DESC"));
                setMethod1Desciption(myBundle.getString("TURNINGTEMPERATURE1_DESCRIPTION"));
            } else if (methodName3Value.equalsIgnoreCase("3. turningHumidity1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_TURNHUMI1_DESC"));
                setMethod1Desciption(myBundle.getString("TURNINGHUMIDITY1_DESCRIPTION"));
            } else if (methodName3Value.equalsIgnoreCase("3. turningPressure1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_TURNPRESS1_DESC"));
                setMethod1Desciption(myBundle.getString("TURNINGPRESSURE1_DESCRIPTION"));
            }
        } else if (methodNameId.equalsIgnoreCase("ot8")) {
            String methodName4Value = clientEvent.getComponent().getAttributes().get("methodName4").toString();

            if (methodName4Value.equalsIgnoreCase("4. turningTemperature2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_TURNTEMP2_DESC"));
                setMethod1Desciption(myBundle.getString("TURNINGTEMPERATURE2_DESCRIPTION"));
            } else if (methodName4Value.equalsIgnoreCase("4. turningHumidity2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_TURNHUMI2_DESC"));
                setMethod1Desciption(myBundle.getString("TURNINGHUMIDITY2_DESCRIPTION"));
            } else if (methodName4Value.equalsIgnoreCase("4. turningPressure2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_TURNPRESS2_DESC"));
                setMethod1Desciption(myBundle.getString("TURNINGPRESSURE2_DESCRIPTION"));
            }
        } else if (methodNameId.equalsIgnoreCase("ot9")) {
            String methodName5Value = clientEvent.getComponent().getAttributes().get("methodName5").toString();

            if (methodName5Value.equalsIgnoreCase("5. paintingTemperature1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_PAINTTEMP1_DESC"));
                setMethod1Desciption(myBundle.getString("PAINTINGTEMPERATURE1_DESCRIPTION"));
            } else if (methodName5Value.equalsIgnoreCase("5. paintingPressure1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_PAINTHUMI1_DESC"));
                setMethod1Desciption(myBundle.getString("PAINTINGHUMIDITY1_DESCRIPTION"));
            } else if (methodName5Value.equalsIgnoreCase("5. paintingHumidity1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_PAINTPRESS1_DESC"));
                setMethod1Desciption(myBundle.getString("PAINTINGPRESSURE1_DESCRIPTION"));
            }
        } else if (methodNameId.equalsIgnoreCase("ot10")) {
            String methodName6Value = clientEvent.getComponent().getAttributes().get("methodName6").toString();

            if (methodName6Value.equalsIgnoreCase("6. paintingTemperature2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_PAINTTEMP2_DESC"));
                setMethod1Desciption(myBundle.getString("PAINTINGTEMPERATURE2_DESCRIPTION"));
            } else if (methodName6Value.equalsIgnoreCase("6. paintingPressure2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_PAINTHUMI2_DESC"));
                setMethod1Desciption(myBundle.getString("PAINTINGHUMIDITY2_DESCRIPTION"));
            } else if (methodName6Value.equalsIgnoreCase("6. paintingHumidity2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_PAINTPRESS2_DESC"));
                setMethod1Desciption(myBundle.getString("PAINTINGPRESSURE2_DESCRIPTION"));
            }
        } else if (methodNameId.equalsIgnoreCase("ot11")) {
            String methodName7Value = clientEvent.getComponent().getAttributes().get("methodName7").toString();

            if (methodName7Value.equalsIgnoreCase("7. labellingTemperature1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_LABELTEMP1_DESC"));
                setMethod1Desciption(myBundle.getString("LABELLINGTEMPERATURE1_DESCRIPTION"));
            } else if (methodName7Value.equalsIgnoreCase("7. labellingHumidity1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_LABELHUMI1_DESC"));
                setMethod1Desciption(myBundle.getString("LABELLINGHUMIDITY1_DESCRIPTION"));
            } else if (methodName7Value.equalsIgnoreCase("7. labellingPressure1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_LABELPRESS1_DESC"));
                setMethod1Desciption(myBundle.getString("LABELLINGPRESSURE1_DESCRIPTION"));
            }
        }

        else if (methodNameId.equalsIgnoreCase("ot12")) {
            String methodName8Value = clientEvent.getComponent().getAttributes().get("methodName8").toString();

            if (methodName8Value.equalsIgnoreCase("8. labellingTemperature2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_LABELTEMP2_DESC"));
                setMethod1Desciption(myBundle.getString("LABELLINGTEMPERATURE2_DESCRIPTION"));
            } else if (methodName8Value.equalsIgnoreCase("8. labellingHumidity2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_LABELHUMI2_DESC"));
                setMethod1Desciption(myBundle.getString("LABELLINGHUMIDITY2_DESCRIPTION"));
            } else if (methodName8Value.equalsIgnoreCase("8. labellingPressure2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_LABELPRESS2_DESC"));
                setMethod1Desciption(myBundle.getString("LABELLINGPRESSURE2_DESCRIPTION"));
            }
        }

        else if (methodNameId.equalsIgnoreCase("ot13")) {
            String methodName9Value = clientEvent.getComponent().getAttributes().get("methodName9").toString();

            if (methodName9Value.equalsIgnoreCase("9. packagingTemperature1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_PACKTEMP1_DESC"));
                setMethod1Desciption(myBundle.getString("PACKAGINGTEMPERATURE1_DESCRIPTION"));
            } else if (methodName9Value.equalsIgnoreCase("9. packagingHumidity1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_PACKHUMI1_DESC"));
                setMethod1Desciption(myBundle.getString("PACKAGINGHUMIDITY1_DESCRIPTION"));
            } else if (methodName9Value.equalsIgnoreCase("9. packagingPressure1")) {
                setTitleMethodDesc(myBundle.getString("TITLE_PACKPRESS1_DESC"));
                setMethod1Desciption(myBundle.getString("PACKAGINGPRESSURE1_DESCRIPTION"));
            }
        } else if (methodNameId.equalsIgnoreCase("ot14")) {
            String methodName10Value = clientEvent.getComponent().getAttributes().get("methodName10").toString();
            if (methodName10Value.equalsIgnoreCase("10. packagingTemperature2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_PACKTEMP2_DESC"));
                setMethod1Desciption(myBundle.getString("PACKAGINGTEMPERATURE2_DESCRIPTION"));
            } else if (methodName10Value.equalsIgnoreCase("10. packagingHumidity2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_PACKHUMI2_DESC"));
                setMethod1Desciption(myBundle.getString("PACKAGINGHUMIDITY2_DESCRIPTION"));
            } else if (methodName10Value.equalsIgnoreCase("10. packagingPressure2")) {
                setTitleMethodDesc(myBundle.getString("TITLE_PACKPRESS2_DESC"));
                setMethod1Desciption(myBundle.getString("PACKAGINGPRESSURE2_DESCRIPTION"));
            }
        }

        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getMethodDescriptionPopupBinding().show(hints);
    }

    public void showTemperatureMethods(ActionEvent actionEvent) {
        setHeadingMethodPopup(myBundle.getString("HEADING_NAME_TEMPERATURE"));
        setParentMethod(myBundle.getString("VARIOUS_METHOD_TEMPERATURE"));
        setMethodName1(myBundle.getString("DRILLINGTEMPERATURE1_METHOD"));
        setMethodName2(myBundle.getString("DRILLINGTEMPERATURE2_METHOD"));
        setMethodName3(myBundle.getString("TURNINGTEMPERATURE1_METHOD"));
        setMethodName4(myBundle.getString("TURNINGTEMPERATURE2_METHOD"));
        setMethodName5(myBundle.getString("PAINTINGTEMPERATURE1_METHOD"));
        setMethodName6(myBundle.getString("PAINTINGTEMPERATURE2_METHOD"));
        setMethodName7(myBundle.getString("LABELLINGTEMPERATURE1_METHOD"));
        setMethodName8(myBundle.getString("LABELLINGTEMPERATURE2_METHOD"));
        setMethodName9(myBundle.getString("PACKAGINGTEMPERATURE1_METHOD"));
        setMethodName10(myBundle.getString("PACKAGINGTEMPERATURE2_METHOD"));
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getShowAllMethodNamesBinding().show(hints);
    }

    public void showPressureMethods(ActionEvent actionEvent) {
        setHeadingMethodPopup(myBundle.getString("HEADING_NAME_PRESSURE"));
        setParentMethod(myBundle.getString("VARIOUS_METHOD_PRESSURE"));
        setMethodName1(myBundle.getString("DRILLINGPRESSURE1_METHOD"));
        setMethodName2(myBundle.getString("DRILLINGPRESSURE2_METHOD"));
        setMethodName3(myBundle.getString("TURNINGPRESSURE1_METHOD"));
        setMethodName4(myBundle.getString("TURNINGPRESSURE2_METHOD"));
        setMethodName5(myBundle.getString("PAINTINGPRESSURE1_METHOD"));
        setMethodName6(myBundle.getString("PAINTINGPRESSURE2_METHOD"));
        setMethodName7(myBundle.getString("LABELLINGPRESSURE1_METHOD"));
        setMethodName8(myBundle.getString("LABELLINGPRESSURE2_METHOD"));
        setMethodName9(myBundle.getString("PACKAGINGPRESSURE1_METHOD"));
        setMethodName10(myBundle.getString("PACKAGINGPRESSURE2_METHOD"));
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getShowAllMethodNamesBinding().show(hints);
    }

    public void showHumidityMethods(ActionEvent actionEvent) {
        setHeadingMethodPopup(myBundle.getString("HEADING_NAME_HUMIDITY"));
        setParentMethod(myBundle.getString("VARIOUS_METHOD_HUMIDITY"));
        setMethodName1(myBundle.getString("DRILLINGHUMIDITY1_METHOD"));
        setMethodName2(myBundle.getString("DRILLINGHUMIDITY2_METHOD"));
        setMethodName3(myBundle.getString("TURNINGHUMIDITY1_METHOD"));
        setMethodName4(myBundle.getString("TURNINGHUMIDITY2_METHOD"));
        setMethodName5(myBundle.getString("PAINTINGHUMIDITY1_METHOD"));
        setMethodName6(myBundle.getString("PAINTINGHUMIDITY2_METHOD"));
        setMethodName7(myBundle.getString("LABELLINGHUMIDITY1_METHOD"));
        setMethodName8(myBundle.getString("LABELLINGHUMIDITY2_METHOD"));
        setMethodName9(myBundle.getString("PACKAGINGHUMIDITY1_METHOD"));
        setMethodName10(myBundle.getString("PACKAGINGHUMIDITY2_METHOD"));
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getShowAllMethodNamesBinding().show(hints);
    }


    public MachineActionBean() {
        BindingContext ctx = BindingContext.getCurrent();
        DCBindingContainer bc = (DCBindingContainer) ctx.getCurrentBindingsEntry();
        DCIteratorBinding iterator = bc.findIteratorBinding("DnsVO1Iterator");
        ViewObject dnsView = iterator.getViewObject();
        dnsView.executeQuery();
        Row r = iterator.getCurrentRow();
        urlValue = (String) r.getAttribute("Url");
        newFinalUrl = "http://" + urlValue + ":7077";
    }

    public MethodExpression getMethodExpression(String s) {

        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr = elFactory.createMethodExpression(elctx, s, null, new Class[] {
                                                                       ClientEvent.class });
        return methodExpr;

    }

    public void testServerListener(ClientEvent clientEvent) {
        String clickedComponentId = clientEvent.getComponent().getId();

        String method_name = "method_name=" + clickedComponentId;
        String mat_id = (String) this.getRefIdBinding().getValue();
        mat_id_new = "materialid=" + mat_id;
        String machine = "";
        if (method_name.contains("DRILLING")) {
            machine = "machine=DRILLING";
        }
        if (method_name.contains("TURNING")) {
            machine = "machine=TURNING";
        }
        if (method_name.contains("PAINTING")) {
            machine = "machine=PAINTING";
        }
        if (method_name.contains("LABELLING")) {
            machine = "machine=LABELLING";
        }
        if (method_name.contains("PACKAGING")) {
            machine = "machine=PACKAGING";
        }

        String parameterToPass = mat_id_new + "&" + machine + "&" + method_name;

        HttpRestClient httpRestClient = new HttpRestClient();
        httpRestClient.connectToServer(newFinalUrl, "callesbservice");
        httpRestClient.sendPOSTRequest("");
        httpRestClient.connectToServer(newFinalUrl + "/callesbservice", "deletemethods");
        String jsonString1 = httpRestClient.sendPOSTRequest(parameterToPass);
        AdfFacesContext.getCurrentInstance().addPartialTarget(showAllMethDialogBinding);
        AdfFacesContext.getCurrentInstance().addPartialTarget(showAllMethBinding);
        this.getShowAllMethBinding().cancel();
    }

    public void displayMethodNames(ClientEvent clientEvent) throws ParseException {
        showAllMethDialogBinding.getChildren().clear();
        ClientListenerSet CL = new ClientListenerSet();
        CL.addListener("click", "deleteFunction");
        CL.addCustomServerListener("ServerEventToGetValue",
                                   getMethodExpression("#{pageFlowScope.MachineActionBean.testServerListener}"));

        String methodNameId = clientEvent.getComponent().getId();
        String mat_id = (String) this.getRefIdBinding().getValue();
        mat_id_new = "materialid=" + mat_id;
        String machine = "";
        if (methodNameId.equalsIgnoreCase("cb3")) {
            machine = "machine=" + "DRILLING";
        }
        if (methodNameId.equalsIgnoreCase("cb4")) {
            machine = "machine=" + "TURNING";
        }
        if (methodNameId.equalsIgnoreCase("cb5")) {
            machine = "machine=" + "PAINTING";
        }
        if (methodNameId.equalsIgnoreCase("cb6")) {
            machine = "machine=" + "LABELLING";
        }
        if (methodNameId.equalsIgnoreCase("cb2")) {
            machine = "machine=" + "PACKAGING";
        }
        String parameterToPass = mat_id_new + "&" + machine;
        HttpRestClient httpRestClient = new HttpRestClient();
        httpRestClient.connectToServer(newFinalUrl, "callesbservice");
        httpRestClient.sendPOSTRequest("");
        httpRestClient.connectToServer(newFinalUrl + "/callesbservice", "displaymethods");
        String jsonString1 = httpRestClient.sendPOSTRequest(parameterToPass);
        JSONParser parser1 = new JSONParser();
        JSONObject jsonObject1 = (JSONObject) parser1.parse(jsonString1);
        String allMethods = jsonObject1.get("methods").toString();
        allMethodsName = null;
        if (allMethods != null) {
            allMethodsName = allMethods.split(",");
            int no_of_methods = allMethodsName.length;
            showAllMethDialogBinding.getChildren().clear();
            for (int i = 0; i < no_of_methods; i++) {
                RichLink richLink = new RichLink();
                richLink.setId(allMethodsName[i]);
                richLink.setText(allMethodsName[i]);
                richLink.setIcon("/images/Delete.png");
                richLink.setIconPosition("trailing");
                richLink.setClientComponent(true);
                richLink.setClientListeners(CL);
                addComponent(getShowAllMethDialogBinding(), richLink);
            }
        }
    }

    public void deleteMethodNames(PopupCanceledEvent popupCanceledEvent) {
        showAllMethDialogBinding.getChildren().clear();
    }

    public void showAllMethods(ActionEvent actionEvent) throws ParseException {
        String mat_id = (String) this.getRefIdBinding().getValue();
        mat_id_new = "materialid=" + mat_id;
        String macName = this.getDrillCmdBtnBinding().getId();
        String machine = "";
        if (macName.equalsIgnoreCase("cb3")) {
            machine = "machine=" + "DRILLING";
        }
        String parameterToPass = mat_id_new + "&" + machine;
        HttpRestClient httpRestClient = new HttpRestClient();
        httpRestClient.connectToServer(newFinalUrl, "callesbservice");
        httpRestClient.sendPOSTRequest("");
        httpRestClient.connectToServer(newFinalUrl + "/callesbservice", "displaymethods");
        String jsonString1 = httpRestClient.sendPOSTRequest(parameterToPass);
        JSONParser parser1 = new JSONParser();
        JSONObject jsonObject1 = (JSONObject) parser1.parse(jsonString1);
        String allMethods = jsonObject1.get("methods").toString();
        allMethodsName = null;
        if (allMethods != null) {
            allMethodsName = allMethods.split(",");
            int no_of_methods = allMethodsName.length;
            showAllMethDialogBinding.getChildren().clear();
            for (int i = 0; i < no_of_methods; i++) {
                RichOutputLabel richOutputLabel = new RichOutputLabel();
                richOutputLabel.setId("rol" + i + 1);
                richOutputLabel.setValue(allMethodsName[i]);
                addComponent(getShowAllMethDialogBinding(), richOutputLabel);
            }
        }
    }

    public void addComponent(UIComponent parentUIComponent, UIComponent childUIComponent) {
        parentUIComponent.getChildren().add(childUIComponent);
        AdfFacesContext.getCurrentInstance().addPartialTarget(parentUIComponent);
    }

    public void loadWorkflow(ActionEvent actionEvent) throws ParseException {
        saveWorkflowButtonBinding.setDisabled(false);
        showAllMethDialogBinding.getChildren().clear();
        drillMachMethParam = null;
        turnMachMethParam = null;
        paintMachMethParam = null;
        labelMachMethParam = null;
        packMachMethParam = null;
        String matId = (String) getRefIdBinding().getValue();
        if (matId == null) {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            this.getRfIdPopupBinding().show(hints);
        } else {
            UIComponent dropComponentParent = gc15Binding.getParent();
            reorderedComponentList.clear();
            reorderedComponentList.add("gc15");
            i = 0;
            numberOfParts = String.valueOf(i);
            String mat_id = (String) this.getRefIdBinding().getValue();
            mat_id_new = "materialid=" + mat_id;
            this.gc15Binding.setRendered(false);
            this.gc16Binding.setRendered(false);
            this.gc17Binding.setRendered(false);
            this.gc18Binding.setRendered(false);
            this.gc19Binding.setRendered(false);
            this.gc20Binding.setRendered(false);
            HttpRestClient httpRestClient = new HttpRestClient();
            httpRestClient.connectToServer(newFinalUrl, "callesbservice");
            httpRestClient.sendPOSTRequest("");
            httpRestClient.connectToServer(newFinalUrl + "/callesbservice", "startprocesswithmatid");
            String jsonString = httpRestClient.sendPOSTRequest(mat_id_new);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            ref_IdS12 = (String) jsonObject.get("MATERIAL_ID");
            String flow_pattern = (String) jsonObject.get("flow_pattern");
            if (flow_pattern != null) {
                machines = flow_pattern.split(",");
                int no_of_machines = machines.length;
                for (int i = 0; i < no_of_machines; i++) {
                    if (machines[i].equalsIgnoreCase("Drilling") || machines[i].equalsIgnoreCase("Turning") ||
                        machines[i].equalsIgnoreCase("Painting") || machines[i].equalsIgnoreCase("Labelling") ||
                        machines[i].equalsIgnoreCase("Packaging")) {
                        this.gc20Binding.setRendered(true);
                    }
                    if (machines[i].equalsIgnoreCase("Drilling")) {
                        this.gc15Binding.setRendered(true);
                        reorderedComponentList.add("gc15");
                    } else if (machines[i].equalsIgnoreCase("Turning")) {
                        this.gc16Binding.setRendered(true);
                        reorderedComponentList.add("gc16");
                    } else if (machines[i].equalsIgnoreCase("Painting")) {
                        this.gc17Binding.setRendered(true);
                        reorderedComponentList.add("gc17");
                    } else if (machines[i].equalsIgnoreCase("Labelling")) {
                        this.gc18Binding.setRendered(true);
                        reorderedComponentList.add("gc18");
                    } else if (machines[i].equalsIgnoreCase("Packaging")) {
                        this.gc19Binding.setRendered(true);
                        reorderedComponentList.add("gc19");
                    }
                }
            }
            FacesContext fctx = FacesContext.getCurrentInstance();
            ReorderChildrenComponentChange reorderedChildChange =
                new ReorderChildrenComponentChange(reorderedComponentList);
            reorderedChildChange.changeComponent(dropComponentParent);
            ChangeManager cm = null;
            cm = RequestContext.getCurrentInstance().getChangeManager();
            cm.addComponentChange(fctx, dropComponentParent, reorderedChildChange);
            AdfFacesContext adfFacesCtx = AdfFacesContext.getCurrentInstance();
            adfFacesCtx.addPartialTarget(dropComponentParent);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pgridContainerBinding);
        }
    }

    public void clearWorkflow(ActionEvent actionEvent) {
        allMethodsName = null;
        drillMachMethParam = null;
        turnMachMethParam = null;
        paintMachMethParam = null;
        labelMachMethParam = null;
        packMachMethParam = null;
        this.gc15Binding.setRendered(false);
        this.gc16Binding.setRendered(false);
        this.gc17Binding.setRendered(false);
        this.gc18Binding.setRendered(false);
        this.gc19Binding.setRendered(false);
        this.gc20Binding.setRendered(false);
        this.refIdBinding.setValue("1234");
        HttpRestClient httpRestClient = new HttpRestClient();
        httpRestClient.connectToServer(newFinalUrl, "callesbservice");
        httpRestClient.sendPOSTRequest("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(refIdBinding);
        AdfFacesContext.getCurrentInstance().addPartialTarget(pgridContainerBinding);
    }

    public void saveWfWithMethods(ActionEvent actionEvent) {
        String materialid = this.getRefIdBinding().getValue().toString();
        String matid = materialid.toUpperCase();
        String newmaterialid = "materialid=" + matid;
        String drillingMethods = methodParameter.toString();
        if (methodParameter.isEmpty()) {
            drillMachMethParam = null;
        } else {
            StringBuffer stringBufferDrilling = new StringBuffer();
            for (int i = 0; i < methodParameter.size(); i++) {
                methodParameter.get(i);
                stringBufferDrilling.append(methodParameter.get(i)).append(",");
            }
            drillMachMethParam = stringBufferDrilling.toString();
            drillMachMethParam =
                "drilling_method=" + drillMachMethParam.substring(0, drillMachMethParam.length() - 1).toUpperCase();
        }
        String turningMethods = methodParamTurning.toString();
        if (methodParamTurning.isEmpty()) {
            turnMachMethParam = null;

        } else {
            StringBuffer stringBufferTurning = new StringBuffer();
            for (int i = 0; i < methodParamTurning.size(); i++) {
                methodParamTurning.get(i);
                stringBufferTurning.append(methodParamTurning.get(i)).append(",");
            }
            turnMachMethParam = stringBufferTurning.toString();
            turnMachMethParam =
                "turning_method=" + turnMachMethParam.substring(0, turnMachMethParam.length() - 1).toUpperCase();
        }
        String paintingMethods = methodParamPainting.toString();
        String paintMachMethParam = null;
        String labelMachMethParam = null;
        String packMachMethParam = null;
        if (methodParamPainting.isEmpty()) {
            paintMachMethParam = null;

        } else {
            StringBuffer stringBufferPainting = new StringBuffer();
            for (int i = 0; i < methodParamPainting.size(); i++) {
                methodParamPainting.get(i);
                stringBufferPainting.append(methodParamPainting.get(i)).append(",");
            }
            paintMachMethParam = stringBufferPainting.toString();
            paintMachMethParam =
                "painting_method=" + paintMachMethParam.substring(0, paintMachMethParam.length() - 1).toUpperCase();
        }
        String labellingMethods = methodParamLabelling.toString();
        if (methodParamLabelling.isEmpty()) {
            labelMachMethParam = null;
        } else {
            StringBuffer stringBufferLabelling = new StringBuffer();
            for (int i = 0; i < methodParamLabelling.size(); i++) {
                methodParamLabelling.get(i);
                stringBufferLabelling.append(methodParamLabelling.get(i)).append(",");
            }
            labelMachMethParam = stringBufferLabelling.toString();
            labelMachMethParam =
                "labelling_method=" + labelMachMethParam.substring(0, labelMachMethParam.length() - 1).toUpperCase();
        }
        String packagingMethods = methodParamPackaging.toString();
        if (methodParamPackaging.isEmpty()) {
            packMachMethParam = null;
        } else {
            StringBuffer stringBufferPackaging = new StringBuffer();
            for (int i = 0; i < methodParamPackaging.size(); i++) {
                methodParamPackaging.get(i);
                stringBufferPackaging.append(methodParamPackaging.get(i)).append(",");
            }
            packMachMethParam = stringBufferPackaging.toString();
            packMachMethParam =
                "packaging_method=" + packMachMethParam.substring(0, packMachMethParam.length() - 1).toUpperCase();
        }
        String finalString =
            newmaterialid + "&" + drillMachMethParam + "&" + turnMachMethParam + "&" + paintMachMethParam + "&" +
            labelMachMethParam + "&" + packMachMethParam;
        String jsonObject1 = finalString;
        HttpRestClient httpRestClient = new HttpRestClient();
        httpRestClient.connectToServer(newFinalUrl + "/callesbservice", "updatemethod");
        String jsonString = httpRestClient.sendPOSTRequest(jsonObject1);
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getSaveWorkFlowPopupBinding().show(hints);
    }

    public Object resolveExpression(String el) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        ValueExpression valueExp = expressionFactory.createValueExpression(elContext, el, Object.class);
        return valueExp.getValue(elContext);
    }

    public void setValueToEL(String el, Object val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        ValueExpression exp = expressionFactory.createValueExpression(elContext, el, Object.class);
        exp.setValue(elContext, val);
    }

    public void drillingMethodNameVCE(ValueChangeEvent valueChangeEvent) {
        this.setValueToEL("#{bindings.MethodName.inputValue}", valueChangeEvent.getNewValue());
        if (resolveExpression("#{bindings.MethodName.inputValue}") == null ||
            resolveExpression("#{bindings.MethodName.inputValue}") == "") {
        } else {
            if (resolveExpression("#{bindings.MethodName.inputValue}") == "drillingTemperature1" ||
                resolveExpression("#{bindings.MethodName.inputValue}").equals("drillingTemperature1")) {
            }
            selectMethodName = resolveExpression("#{bindings.MethodName.inputValue}").toString();
        }
    }

    public void turningMethodNameVCE(ValueChangeEvent valueChangeEvent) {
        this.setValueToEL("#{bindings.MethodName.inputValue}", valueChangeEvent.getNewValue());
        if (resolveExpression("#{bindings.MethodName.inputValue}") == null ||
            resolveExpression("#{bindings.MethodName.inputValue}") == "") {
        } else {
            selectTurnMethodName = resolveExpression("#{bindings.MethodName.inputValue}").toString();
        }
    }


    public void paintingMethodNameVCE(ValueChangeEvent valueChangeEvent) {
        this.setValueToEL("#{bindings.MethodName.inputValue}", valueChangeEvent.getNewValue());
        if (resolveExpression("#{bindings.MethodName.inputValue}") == null ||
            resolveExpression("#{bindings.MethodName.inputValue}") == "") {
        } else {
            selectPaintMethodName = resolveExpression("#{bindings.MethodName.inputValue}").toString();
        }
    }


    public void labellingMethodNameVCE(ValueChangeEvent valueChangeEvent) {
        this.setValueToEL("#{bindings.MethodName.inputValue}", valueChangeEvent.getNewValue());
        if (resolveExpression("#{bindings.MethodName.inputValue}") == null ||
            resolveExpression("#{bindings.MethodName.inputValue}") == "") {
        } else {
            selectLabelMethodName = resolveExpression("#{bindings.MethodName.inputValue}").toString();
        }
    }

    public void packagingMethodNameVCE(ValueChangeEvent valueChangeEvent) {
        this.setValueToEL("#{bindings.MethodName.inputValue}", valueChangeEvent.getNewValue());
        if (resolveExpression("#{bindings.MethodName.inputValue}") == null ||
            resolveExpression("#{bindings.MethodName.inputValue}") == "") {
        } else {
            selectPackMethodName = resolveExpression("#{bindings.MethodName.inputValue}").toString();
        }
    }

    public DCBindingContainer getBindings() {
        return (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public DnDAction handleDndDT(DropEvent dropEvent) throws ParseException {
        selectMethodName = null;
        allAddedDrillTempMethods.clear();
        String containerId = this.getDrillCmdBtnBinding().getId();
        String dragComponent = dropEvent.getDragComponent().getId();
        if (containerId.equalsIgnoreCase("cb3") && dragComponent.equalsIgnoreCase("cb11")) {
            machinename = "Drilling";
            attributename = "Temperature";
        } else if (containerId.equalsIgnoreCase("cb3") && dragComponent.equalsIgnoreCase("cb1")) {
            machinename = "Drilling";
            attributename = "Humidity";
        } else if (containerId.equalsIgnoreCase("cb3") && dragComponent.equalsIgnoreCase("cb7")) {
            machinename = "Drilling";
            attributename = "Pressure";
        }
        DCBindingContainer bindings = getBindings();
        OperationBinding method = (OperationBinding) bindings.get("searchByMachineName");
        method.getParamsMap().put("machinename", machinename);
        method.getParamsMap().put("attributename", attributename);
        String machine = machinename.toUpperCase();
        String attribute = attributename.toUpperCase();
        HttpRestClient httpRestClient = new HttpRestClient();
        httpRestClient.connectToServer(newFinalUrl, "callesbservice");
        httpRestClient.sendPOSTRequest("");
        httpRestClient.connectToServer(newFinalUrl + "/callesbservice", "machineattribute");
        String finalStringToPass = mat_id_new + "&machine=" + machine + "&attribute=" + attribute;
        String jsonString = httpRestClient.sendPOSTRequest(finalStringToPass);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
        String all_methods = (String) jsonObject.get("methods");
        if (all_methods != null) {
            methods = all_methods.split(",");
            int no_of_methods = methods.length;
            for (int i = 0; i < no_of_methods; i++) {
                allAddedDrillTempMethods.add(methods[i]);
            }
        }
        method.execute();
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getShowMetParPopBinding().show(hints);
        return DnDAction.NONE;
    }


    public DnDAction handleDndTurning(DropEvent dropEvent) throws ParseException {
        selectTurnMethodName = null;
        allAddedTurningMethods.clear();
        String containerId = this.getTurnCmdBtnBinding().getId();
        String dragComponent = dropEvent.getDragComponent().getId();
        if (containerId.equalsIgnoreCase("cb4") && dragComponent.equalsIgnoreCase("cb11")) {
            machinename = "Turning";
            attributename = "Temperature";
        } else if (containerId.equalsIgnoreCase("cb4") && dragComponent.equalsIgnoreCase("cb1")) {
            machinename = "Turning";
            attributename = "Humidity";
        } else if (containerId.equalsIgnoreCase("cb4") && dragComponent.equalsIgnoreCase("cb7")) {
            machinename = "Turning";
            attributename = "Pressure";
        }
        DCBindingContainer bindings = getBindings();
        OperationBinding method = (OperationBinding) bindings.get("searchByMachineName");
        method.getParamsMap().put("machinename", machinename);
        method.getParamsMap().put("attributename", attributename);
        String machine = machinename.toUpperCase();
        String attribute = attributename.toUpperCase();
        HttpRestClient httpRestClient = new HttpRestClient();
        httpRestClient.connectToServer(newFinalUrl, "callesbservice");
        httpRestClient.sendPOSTRequest("");
        httpRestClient.connectToServer(newFinalUrl + "/callesbservice", "machineattribute");
        String finalStringToPass = mat_id_new + "&machine=" + machine + "&attribute=" + attribute;
        String jsonString = httpRestClient.sendPOSTRequest(finalStringToPass);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
        String all_methods = (String) jsonObject.get("methods");
        if (all_methods != null) {
            methods = all_methods.split(",");
            int no_of_methods = methods.length;
            for (int i = 0; i < no_of_methods; i++) {
                allAddedTurningMethods.add(methods[i]);
            }
        }
        method.execute();
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getShowMetParPopBindTurn().show(hints);
        return DnDAction.NONE;
    }

    public DnDAction handleDndPaint(DropEvent dropEvent) throws ParseException {
        selectPaintMethodName = null;
        allAddedPaintingMethods.clear();
        String containerIdPaint = this.getPaintCmdBtnBinding().getId();
        String dragComponent = dropEvent.getDragComponent().getId();
        if (containerIdPaint.equalsIgnoreCase("cb5") && dragComponent.equalsIgnoreCase("cb11")) {
            machinename = "Painting";
            attributename = "Temperature";
        } else if (containerIdPaint.equalsIgnoreCase("cb5") && dragComponent.equalsIgnoreCase("cb1")) {
            machinename = "Painting";
            attributename = "Humidity";
        } else if (containerIdPaint.equalsIgnoreCase("cb5") && dragComponent.equalsIgnoreCase("cb7")) {
            machinename = "Painting";
            attributename = "Pressure";
        }
        DCBindingContainer bindings = getBindings();
        OperationBinding method = (OperationBinding) bindings.get("searchByMachineName");
        method.getParamsMap().put("machinename", machinename);
        method.getParamsMap().put("attributename", attributename);
        String machine = machinename.toUpperCase();
        String attribute = attributename.toUpperCase();
        HttpRestClient httpRestClient = new HttpRestClient();
        httpRestClient.connectToServer(newFinalUrl, "callesbservice");
        httpRestClient.sendPOSTRequest("");
        httpRestClient.connectToServer(newFinalUrl + "/callesbservice", "machineattribute");
        String finalStringToPass = mat_id_new + "&machine=" + machine + "&attribute=" + attribute;
        String jsonString = httpRestClient.sendPOSTRequest(finalStringToPass);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
        String all_methods = (String) jsonObject.get("methods");
        if (all_methods != null) {
            methods = all_methods.split(",");
            int no_of_methods = methods.length;
            for (int i = 0; i < no_of_methods; i++) {
                allAddedPaintingMethods.add(methods[i]);
            }
        }
        method.execute();
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getShowMetParPopBindPaint().show(hints);
        return DnDAction.NONE;
    }

    public DnDAction handleDndLabel(DropEvent dropEvent) throws ParseException {
        selectLabelMethodName = null;
        allAddedLabellingMethods.clear();
        String containerIdLabel = this.getLabelCmdBtnBinding().getId();
        String dragComponent = dropEvent.getDragComponent().getId();
        if (containerIdLabel.equalsIgnoreCase("cb6") && dragComponent.equalsIgnoreCase("cb11")) {
            machinename = "Labelling";
            attributename = "Temperature";
        } else if (containerIdLabel.equalsIgnoreCase("cb6") && dragComponent.equalsIgnoreCase("cb1")) {
            machinename = "Labelling";
            attributename = "Humidity";
        } else if (containerIdLabel.equalsIgnoreCase("cb6") && dragComponent.equalsIgnoreCase("cb7")) {
            machinename = "Labelling";
            attributename = "Pressure";
        }
        DCBindingContainer bindings = getBindings();
        OperationBinding method = (OperationBinding) bindings.get("searchByMachineName");
        method.getParamsMap().put("machinename", machinename);
        method.getParamsMap().put("attributename", attributename);
        String machine = machinename.toUpperCase();
        String attribute = attributename.toUpperCase();
        HttpRestClient httpRestClient = new HttpRestClient();
        httpRestClient.connectToServer(newFinalUrl, "callesbservice");
        httpRestClient.sendPOSTRequest("");
        httpRestClient.connectToServer(newFinalUrl + "/callesbservice", "machineattribute");
        String finalStringToPass = mat_id_new + "&machine=" + machine + "&attribute=" + attribute;
        String jsonString = httpRestClient.sendPOSTRequest(finalStringToPass);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
        String all_methods = (String) jsonObject.get("methods");
        if (all_methods != null) {
            methods = all_methods.split(",");
            int no_of_methods = methods.length;
            for (int i = 0; i < no_of_methods; i++) {
                allAddedLabellingMethods.add(methods[i]);
            }
        }
        method.execute();
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getShowMetParPopBindLabel().show(hints);
        return DnDAction.NONE;
    }

    public DnDAction handleDndPack(DropEvent dropEvent) throws ParseException {
        selectPackMethodName = null;
        allAddedPackagingMethods.clear();
        String containerIdPack = this.getPackCmdBtnBinding().getId();
        String dragComponent = dropEvent.getDragComponent().getId();
        if (containerIdPack.equalsIgnoreCase("cb2") && dragComponent.equalsIgnoreCase("cb11")) {
            machinename = "Packaging";
            attributename = "Temperature";
        } else if (containerIdPack.equalsIgnoreCase("cb2") && dragComponent.equalsIgnoreCase("cb1")) {
            machinename = "Packaging";
            attributename = "Humidity";
        } else if (containerIdPack.equalsIgnoreCase("cb2") && dragComponent.equalsIgnoreCase("cb7")) {
            machinename = "Packaging";
            attributename = "Pressure";
        }
        DCBindingContainer bindings = getBindings();
        OperationBinding method = (OperationBinding) bindings.get("searchByMachineName");
        method.getParamsMap().put("machinename", machinename);
        method.getParamsMap().put("attributename", attributename);
        String machine = machinename.toUpperCase();
        String attribute = attributename.toUpperCase();
        HttpRestClient httpRestClient = new HttpRestClient();
        httpRestClient.connectToServer(newFinalUrl, "callesbservice");
        httpRestClient.sendPOSTRequest("");
        httpRestClient.connectToServer(newFinalUrl + "/callesbservice", "machineattribute");
        String finalStringToPass = mat_id_new + "&machine=" + machine + "&attribute=" + attribute;
        String jsonString = httpRestClient.sendPOSTRequest(finalStringToPass);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
        String all_methods = (String) jsonObject.get("methods");
        if (all_methods != null) {
            methods = all_methods.split(",");
            int no_of_methods = methods.length;
            for (int i = 0; i < no_of_methods; i++) {
                allAddedPackagingMethods.add(methods[i]);
            }
        }
        method.execute();
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getShowMetParPopBindPack().show(hints);
        return DnDAction.NONE;
    }

    public void addMethodParam(ActionEvent actionEvent) {
        if (selectMethodName == null || selectMethodName == "") {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            this.getSelectMethodNamePopupBinding().show(hints);
        } else {
            String dtparam1 = getParam1Binding().getValue().toString();
            String dtparam2 = getParam2Binding().getValue().toString();
            methodParameter.add(selectMethodName);
            methodParameter.add(dtparam1);
            methodParameter.add(dtparam2);
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            this.getShowMetParPopBinding().cancel();
        }
    }

    public void addMethParamTurn(ActionEvent actionEvent) {
        if (selectTurnMethodName == null || selectTurnMethodName == "") {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            this.getSelectMethodNamePopupBinding().show(hints);
        } else {
            String dtparam1 = getParam1BindTurn().getValue().toString();
            String dtparam2 = getParam2BindTurn().getValue().toString();
            methodParamTurning.add(selectTurnMethodName);
            methodParamTurning.add(dtparam1);
            methodParamTurning.add(dtparam2);
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            this.getShowMetParPopBindTurn().cancel();
        }
    }


    public void addMethParamPaint(ActionEvent actionEvent) {
        if (selectPaintMethodName == null || selectPaintMethodName == "") {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            this.getSelectMethodNamePopupBinding().show(hints);
        } else {
            String dtparam1 = getParam1BindPaint().getValue().toString();
            String dtparam2 = getParam2BindPaint().getValue().toString();
            methodParamPainting.add(selectPaintMethodName);
            methodParamPainting.add(dtparam1);
            methodParamPainting.add(dtparam2);
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            this.getShowMetParPopBindPaint().cancel();
        }
    }

    public void addMethParamLabel(ActionEvent actionEvent) {
        if (selectLabelMethodName == null || selectLabelMethodName == "") {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            this.getSelectMethodNamePopupBinding().show(hints);
        } else {
            String dtparam1 = getParam1BindLabel().getValue().toString();
            String dtparam2 = getParam2BindLabel().getValue().toString();
            methodParamLabelling.add(selectLabelMethodName);
            methodParamLabelling.add(dtparam1);
            methodParamLabelling.add(dtparam2);
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            this.getShowMetParPopBindLabel().cancel();
        }
    }

    public void addMethParamPack(ActionEvent actionEvent) {
        if (selectPackMethodName == null || selectPackMethodName == "") {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            this.getSelectMethodNamePopupBinding().show(hints);
        } else {
            String dtparam1 = getParam1BindPack().getValue().toString();
            String dtparam2 = getParam2BindPack().getValue().toString();
            methodParamPackaging.add(selectPackMethodName);
            methodParamPackaging.add(dtparam1);
            methodParamPackaging.add(dtparam2);
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            this.getShowMetParPopBindPack().cancel();
        }
    }

    public void setGc15Binding(RichGridCell gc15Binding) {
        this.gc15Binding = gc15Binding;
    }

    public RichGridCell getGc15Binding() {
        return gc15Binding;
    }

    public void setGc16Binding(RichGridCell gc16Binding) {
        this.gc16Binding = gc16Binding;
    }

    public RichGridCell getGc16Binding() {
        return gc16Binding;
    }

    public void setGc17Binding(RichGridCell gc17Binding) {
        this.gc17Binding = gc17Binding;
    }

    public RichGridCell getGc17Binding() {
        return gc17Binding;
    }

    public void setGc18Binding(RichGridCell gc18Binding) {
        this.gc18Binding = gc18Binding;
    }

    public RichGridCell getGc18Binding() {
        return gc18Binding;
    }

    public void setGc19Binding(RichGridCell gc19Binding) {
        this.gc19Binding = gc19Binding;
    }

    public RichGridCell getGc19Binding() {
        return gc19Binding;
    }

    public void setRefIdBinding(RichInputText refIdBinding) {
        this.refIdBinding = refIdBinding;
    }

    public RichInputText getRefIdBinding() {
        return refIdBinding;
    }

    public void setPgridContainerBinding(RichPanelGroupLayout pgridContainerBinding) {
        this.pgridContainerBinding = pgridContainerBinding;
    }

    public RichPanelGroupLayout getPgridContainerBinding() {
        return pgridContainerBinding;
    }

    public void setGc20Binding(RichGridCell gc20Binding) {
        this.gc20Binding = gc20Binding;
    }

    public RichGridCell getGc20Binding() {
        return gc20Binding;
    }

    public void setRfIdPopupBinding(RichPopup rfIdPopupBinding) {
        this.rfIdPopupBinding = rfIdPopupBinding;
    }

    public RichPopup getRfIdPopupBinding() {
        return rfIdPopupBinding;
    }

    public void setParam1Binding(RichInputText param1Binding) {
        this.param1Binding = param1Binding;
    }

    public RichInputText getParam1Binding() {
        return param1Binding;
    }

    public void setParam2Binding(RichInputText param2Binding) {
        this.param2Binding = param2Binding;
    }

    public RichInputText getParam2Binding() {
        return param2Binding;
    }

    public void setShowMetParPopBinding(RichPopup showMetParPopBinding) {
        this.showMetParPopBinding = showMetParPopBinding;
    }

    public RichPopup getShowMetParPopBinding() {
        return showMetParPopBinding;
    }

    public void setDrillCmdBtnBinding(RichCommandButton drillCmdBtnBinding) {
        this.drillCmdBtnBinding = drillCmdBtnBinding;
    }

    public RichCommandButton getDrillCmdBtnBinding() {
        return drillCmdBtnBinding;
    }


    public void setShowMetParPopBindTurn(RichPopup showMetParPopBindTurn) {
        this.showMetParPopBindTurn = showMetParPopBindTurn;
    }

    public RichPopup getShowMetParPopBindTurn() {
        return showMetParPopBindTurn;
    }

    public void setMethNameBindTurn(RichInputText methNameBindTurn) {
        this.methNameBindTurn = methNameBindTurn;
    }

    public RichInputText getMethNameBindTurn() {
        return methNameBindTurn;
    }

    public void setParam1BindTurn(RichInputText param1BindTurn) {
        this.param1BindTurn = param1BindTurn;
    }

    public RichInputText getParam1BindTurn() {
        return param1BindTurn;
    }

    public void setParam2BindTurn(RichInputText param2BindTurn) {
        this.param2BindTurn = param2BindTurn;
    }

    public RichInputText getParam2BindTurn() {
        return param2BindTurn;
    }


    public void setTurnCmdBtnBinding(RichCommandButton turnCmdBtnBinding) {
        this.turnCmdBtnBinding = turnCmdBtnBinding;
    }

    public RichCommandButton getTurnCmdBtnBinding() {
        return turnCmdBtnBinding;
    }


    public void setShowMetParPopBindPaint(RichPopup showMetParPopBindPaint) {
        this.showMetParPopBindPaint = showMetParPopBindPaint;
    }

    public RichPopup getShowMetParPopBindPaint() {
        return showMetParPopBindPaint;
    }

    public void setMethNameBindPaint(RichInputText methNameBindPaint) {
        this.methNameBindPaint = methNameBindPaint;
    }

    public RichInputText getMethNameBindPaint() {
        return methNameBindPaint;
    }

    public void setParam1BindPaint(RichInputText param1BindPaint) {
        this.param1BindPaint = param1BindPaint;
    }

    public RichInputText getParam1BindPaint() {
        return param1BindPaint;
    }

    public void setParam2BindPaint(RichInputText param2BindPaint) {
        this.param2BindPaint = param2BindPaint;
    }

    public RichInputText getParam2BindPaint() {
        return param2BindPaint;
    }

    public void setPaintCmdBtnBinding(RichCommandButton paintCmdBtnBinding) {
        this.paintCmdBtnBinding = paintCmdBtnBinding;
    }

    public RichCommandButton getPaintCmdBtnBinding() {
        return paintCmdBtnBinding;
    }

    public void setLabelCmdBtnBinding(RichCommandButton labelCmdBtnBinding) {
        this.labelCmdBtnBinding = labelCmdBtnBinding;
    }

    public RichCommandButton getLabelCmdBtnBinding() {
        return labelCmdBtnBinding;
    }


    public void setMethNameBindLabel(RichInputText methNameBindLabel) {
        this.methNameBindLabel = methNameBindLabel;
    }

    public RichInputText getMethNameBindLabel() {
        return methNameBindLabel;
    }

    public void setParam1BindLabel(RichInputText param1BindLabel) {
        this.param1BindLabel = param1BindLabel;
    }

    public RichInputText getParam1BindLabel() {
        return param1BindLabel;
    }

    public void setParam2BindLabel(RichInputText param2BindLabel) {
        this.param2BindLabel = param2BindLabel;
    }

    public RichInputText getParam2BindLabel() {
        return param2BindLabel;
    }


    public void setShowMetParPopBindLabel(RichPopup showMetParPopBindLabel) {
        this.showMetParPopBindLabel = showMetParPopBindLabel;
    }

    public RichPopup getShowMetParPopBindLabel() {
        return showMetParPopBindLabel;
    }

    public void setPackCmdBtnBinding(RichCommandButton packCmdBtnBinding) {
        this.packCmdBtnBinding = packCmdBtnBinding;
    }

    public RichCommandButton getPackCmdBtnBinding() {
        return packCmdBtnBinding;
    }


    public void setShowMetParPopBindPack(RichPopup showMetParPopBindPack) {
        this.showMetParPopBindPack = showMetParPopBindPack;
    }

    public RichPopup getShowMetParPopBindPack() {
        return showMetParPopBindPack;
    }

    public void setMethNameBindPack(RichInputText methNameBindPack) {
        this.methNameBindPack = methNameBindPack;
    }

    public RichInputText getMethNameBindPack() {
        return methNameBindPack;
    }

    public void setParam1BindPack(RichInputText param1BindPack) {
        this.param1BindPack = param1BindPack;
    }

    public RichInputText getParam1BindPack() {
        return param1BindPack;
    }

    public void setParam2BindPack(RichInputText param2BindPack) {
        this.param2BindPack = param2BindPack;
    }

    public RichInputText getParam2BindPack() {
        return param2BindPack;
    }


    public void setMatIDDropDownBinding(RichSelectOneChoice matIDDropDownBinding) {
        this.matIDDropDownBinding = matIDDropDownBinding;
    }

    public RichSelectOneChoice getMatIDDropDownBinding() {
        return matIDDropDownBinding;
    }


    public void setMethNameSOCBinding(RichSelectOneChoice methNameSOCBinding) {
        this.methNameSOCBinding = methNameSOCBinding;
        this.methNameSOCBinding.setValue(0);
    }

    public RichSelectOneChoice getMethNameSOCBinding() {
        return methNameSOCBinding;
    }

    public void setTurnMethNameSOCBinding(RichSelectOneChoice turnMethNameSOCBinding) {
        this.turnMethNameSOCBinding = turnMethNameSOCBinding;
        this.turnMethNameSOCBinding.setValue(0);
    }

    public RichSelectOneChoice getTurnMethNameSOCBinding() {
        return turnMethNameSOCBinding;
    }

    public void setPaintMethNameSOCBinding(RichSelectOneChoice paintMethNameSOCBinding) {
        this.paintMethNameSOCBinding = paintMethNameSOCBinding;
        this.paintMethNameSOCBinding.setValue(0);
    }

    public RichSelectOneChoice getPaintMethNameSOCBinding() {
        return paintMethNameSOCBinding;
    }

    public void setLabelMethNameSOCBinding(RichSelectOneChoice labelMethNameSOCBinding) {
        this.labelMethNameSOCBinding = labelMethNameSOCBinding;
        this.labelMethNameSOCBinding.setValue(0);
    }

    public RichSelectOneChoice getLabelMethNameSOCBinding() {
        return labelMethNameSOCBinding;
    }


    public void setPackMethNameSOCBinding(RichSelectOneChoice packMethNameSOCBinding) {
        this.packMethNameSOCBinding = packMethNameSOCBinding;
        this.packMethNameSOCBinding.setValue(0);
    }

    public RichSelectOneChoice getPackMethNameSOCBinding() {
        return packMethNameSOCBinding;
    }


    public void setShowAllMethBinding(RichPopup showAllMethBinding) {
        this.showAllMethBinding = showAllMethBinding;
    }

    public RichPopup getShowAllMethBinding() {
        return showAllMethBinding;
    }


    public void setTestBinding(RichPanelFormLayout testBinding) {
        this.testBinding = testBinding;
    }

    public RichPanelFormLayout getTestBinding() {
        return testBinding;
    }


    public void setMethodName1(String methodName1) {
        this.methodName1 = methodName1;
    }

    public String getMethodName1() {
        return methodName1;
    }

    public void setMethodName2(String methodName2) {
        this.methodName2 = methodName2;
    }

    public String getMethodName2() {
        return methodName2;
    }

    public void setMethodName3(String methodName3) {
        this.methodName3 = methodName3;
    }

    public String getMethodName3() {
        return methodName3;
    }

    public void setMethodName4(String methodName4) {
        this.methodName4 = methodName4;
    }

    public String getMethodName4() {
        return methodName4;
    }

    public void setMethodName5(String methodName5) {
        this.methodName5 = methodName5;
    }

    public String getMethodName5() {
        return methodName5;
    }

    public void setMethodName6(String methodName6) {
        this.methodName6 = methodName6;
    }

    public String getMethodName6() {
        return methodName6;
    }

    public void setMethodName7(String methodName7) {
        this.methodName7 = methodName7;
    }

    public String getMethodName7() {
        return methodName7;
    }

    public void setMethodName8(String methodName8) {
        this.methodName8 = methodName8;
    }

    public String getMethodName8() {
        return methodName8;
    }

    public void setMethodName9(String methodName9) {
        this.methodName9 = methodName9;
    }

    public String getMethodName9() {
        return methodName9;
    }

    public void setMethodName10(String methodName10) {
        this.methodName10 = methodName10;
    }

    public String getMethodName10() {
        return methodName10;
    }


    public void setShowAllMethodNamesBinding(RichPopup showAllMethodNamesBinding) {
        this.showAllMethodNamesBinding = showAllMethodNamesBinding;
    }

    public RichPopup getShowAllMethodNamesBinding() {
        return showAllMethodNamesBinding;
    }

    public void setParentMethod(String parentMethod) {
        this.parentMethod = parentMethod;
    }

    public String getParentMethod() {
        return parentMethod;
    }

    public void setHeadingMethodPopup(String headingMethodPopup) {
        this.headingMethodPopup = headingMethodPopup;
    }

    public String getHeadingMethodPopup() {
        return headingMethodPopup;
    }


    public void setMethodDescriptionPopupBinding(RichPopup methodDescriptionPopupBinding) {
        this.methodDescriptionPopupBinding = methodDescriptionPopupBinding;
    }

    public RichPopup getMethodDescriptionPopupBinding() {
        return methodDescriptionPopupBinding;
    }

    public void setMethod1Desciption(String method1Desciption) {
        this.method1Desciption = method1Desciption;
    }

    public String getMethod1Desciption() {
        return method1Desciption;
    }

    public void setMethod2Desciption(String method2Desciption) {
        this.method2Desciption = method2Desciption;
    }

    public String getMethod2Desciption() {
        return method2Desciption;
    }

    public void setMethod3Desciption(String method3Desciption) {
        this.method3Desciption = method3Desciption;
    }

    public String getMethod3Desciption() {
        return method3Desciption;
    }

    public void setMethod4Desciption(String method4Desciption) {
        this.method4Desciption = method4Desciption;
    }

    public String getMethod4Desciption() {
        return method4Desciption;
    }

    public void setMethod5Desciption(String method5Desciption) {
        this.method5Desciption = method5Desciption;
    }

    public String getMethod5Desciption() {
        return method5Desciption;
    }

    public void setMethod6Desciption(String method6Desciption) {
        this.method6Desciption = method6Desciption;
    }

    public String getMethod6Desciption() {
        return method6Desciption;
    }

    public void setMethod7Desciption(String method7Desciption) {
        this.method7Desciption = method7Desciption;
    }

    public String getMethod7Desciption() {
        return method7Desciption;
    }

    public void setMethod8Desciption(String method8Desciption) {
        this.method8Desciption = method8Desciption;
    }

    public String getMethod8Desciption() {
        return method8Desciption;
    }

    public void setMethod9Desciption(String method9Desciption) {
        this.method9Desciption = method9Desciption;
    }

    public String getMethod9Desciption() {
        return method9Desciption;
    }

    public void setMethod10Desciption(String method10Desciption) {
        this.method10Desciption = method10Desciption;
    }

    public String getMethod10Desciption() {
        return method10Desciption;
    }

    public void setTitleMethodDesc(String titleMethodDesc) {
        this.titleMethodDesc = titleMethodDesc;
    }

    public String getTitleMethodDesc() {
        return titleMethodDesc;
    }


    public void setPglMethodNameBindings(RichPanelGroupLayout pglMethodNameBindings) {
        this.pglMethodNameBindings = pglMethodNameBindings;
    }

    public RichPanelGroupLayout getPglMethodNameBindings() {
        return pglMethodNameBindings;
    }


    public void setSaveWorkflowButtonBinding(RichButton saveWorkflowButtonBinding) {
        this.saveWorkflowButtonBinding = saveWorkflowButtonBinding;
    }

    public RichButton getSaveWorkflowButtonBinding() {
        return saveWorkflowButtonBinding;
    }

    public void setShowAllMethDialogBinding(RichDialog showAllMethDialogBinding) {
        this.showAllMethDialogBinding = showAllMethDialogBinding;
    }

    public RichDialog getShowAllMethDialogBinding() {
        return showAllMethDialogBinding;
    }

    public void setSaveWorkFlowPopupBinding(RichPopup saveWorkFlowPopupBinding) {
        this.saveWorkFlowPopupBinding = saveWorkFlowPopupBinding;
    }

    public RichPopup getSaveWorkFlowPopupBinding() {
        return saveWorkFlowPopupBinding;
    }

    public void englishLanguage(ActionEvent actionEvent) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
    }

    public void deutschLanguage(ActionEvent actionEvent) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.GERMAN);
    }

    public void setSelectMethodNamePopupBinding(RichPopup selectMethodNamePopupBinding) {
        this.selectMethodNamePopupBinding = selectMethodNamePopupBinding;
    }

    public RichPopup getSelectMethodNamePopupBinding() {
        return selectMethodNamePopupBinding;
    }

    public void setAllAddedDrillTempMethods(List<String> allAddedDrillTempMethods) {
        this.allAddedDrillTempMethods = allAddedDrillTempMethods;
    }

    public List<String> getAllAddedDrillTempMethods() {
        return allAddedDrillTempMethods;
    }

    public void setAllAddedTurningMethods(List<String> allAddedTurningMethods) {
        this.allAddedTurningMethods = allAddedTurningMethods;
    }

    public List<String> getAllAddedTurningMethods() {
        return allAddedTurningMethods;
    }

    public void setAllAddedPaintingMethods(List<String> allAddedPaintingMethods) {
        this.allAddedPaintingMethods = allAddedPaintingMethods;
    }

    public List<String> getAllAddedPaintingMethods() {
        return allAddedPaintingMethods;
    }

    public void setAllAddedLabellingMethods(List<String> allAddedLabellingMethods) {
        this.allAddedLabellingMethods = allAddedLabellingMethods;
    }

    public List<String> getAllAddedLabellingMethods() {
        return allAddedLabellingMethods;
    }

    public void setAllAddedPackagingMethods(List<String> allAddedPackagingMethods) {
        this.allAddedPackagingMethods = allAddedPackagingMethods;
    }

    public List<String> getAllAddedPackagingMethods() {
        return allAddedPackagingMethods;
    }

}
