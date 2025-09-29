package com.susanto.beans;

import java.awt.Desktop;

import java.io.DataInputStream;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPoll;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

import java.io.InputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;


import java.net.UnknownHostException;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichPanelBorderLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;

import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.change.ChangeManager;
import org.apache.myfaces.trinidad.change.ReorderChildrenComponentChange;
import org.apache.myfaces.trinidad.context.RequestContext;
import org.apache.myfaces.trinidad.event.PollEvent;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UserBean {
    private RichPanelBorderLayout workSt1Block;
    private RichPanelBorderLayout workSt2Block;
    private RichPanelBorderLayout workSt3Block;
    private RichPanelBorderLayout workSt4Block;
    private RichPanelBorderLayout workSt5Block;
    private RichImage dnArrow1;
    private RichImage dnArrow2;
    private RichImage dnArrow3;
    private RichImage dnArrow4;
    private RichImage dnArrow5;
    private RichPanelGroupLayout inParams1;
    private RichPanelGroupLayout inParams2;
    private RichPanelGroupLayout inParams3;
    private RichPanelGroupLayout inParams4;
    private RichPanelGroupLayout inParams5;
    private RichImage upArrow1;
    private String numberOfParts = "0";
    private RichPanelGroupLayout partsProcessed;
    private RichPanelLabelAndMessage numberOfPartsP;
    private RichPanelBox panelBox1;
    private boolean entry5 = false;
    private boolean rejected = false;
    private RichImage upArrow2;
    private RichImage upArrow3;
    private RichImage upArrow4;
    private RichImage upArrow5;
    private RichPanelGroupLayout outParams1;
    private RichPanelGroupLayout outParams2;
    private RichPanelGroupLayout outParams3;
    private RichPanelGroupLayout outParams4;
    private RichPanelGroupLayout outParams5;
    private RichPanelGroupLayout outTemp1;
    private int i = 0;
    private int noOfP1 = 0;


    private RichPoll pollLstnr15;
    private RichPoll pollLstnr16;


    private int z[] = new int[100000];
    private RichImage truck;
    private RichPanelBorderLayout workstation4R;
    private RichOutputText rejectedPartWS4;
    private RichImage invCntWarnng;
    private RichPanelLabelAndMessage invntryCount;

    private String inputP01;
    private String inputP02;
    private String inputP03;
    private String inputP04;
    private String inputP11;
    private String inputP12;
    private String inputP13;
    private String inputP14;
    private String outputP11;
    private String outputP12;
    private String outputP13;

    private String outputP14;
    private String outTemp11;
    private String outHumid11;
    private String outRandomP1;
    private String myProcessingUnid1;


    private String inputP21;
    private String inputP22;
    private String inputP23;
    private String inputP24;
    private String outputP21;
    private String outputP22;
    private String outputP23;
    private String outputP24;
    private String outTemp21;
    private String outHumid21;
    private String outRandomP2;
    private String myProcessingUnid2;


    private String inputP31;
    private String inputP32;
    private String inputP33;
    private String inputP34;
    private String outputP31;

    private String outputP32;
    private String outputP33;
    private String outputP34;
    private String outTemp31;
    private String outHumid31;
    private String outRandomP3;
    private String myProcessingUnid3;


    private String inputP41;
    private String inputP42;
    private String inputP43;
    private String inputP44;
    private String outputP41;
    private String outputP42;
    private String outputP43;
    private String outputP44;
    private String outTemp41;
    private String outHumid41;
    private String outRandomP4;
    private String myProcessingUnid4;

    private String inputP51;
    private String inputP52;
    private String inputP53;
    private String inputP54;
    private String outputP51;
    private String outputP52;
    private String outputP53;
    private String outputP54;
    private String outTemp51;
    private String outHumid51;
    private String outRandomP5;
    private String myProcessingUnid5;
    private String machines[] = null;


    private RichInputText refIdBinding;
    private final static String GET = "GET";
    private final static String POST = "POST";
    private HttpURLConnection restClient;
    private RichPanelGroupLayout workflowContainer;
    private RichButton startWorkflowBinding;
    private RichButton clearWorkflowBinding;
    private RichButton loadWorkflowBinding;
    private RichPanelGroupLayout buttonContainerBinding;
    private RichGridCell wsGrid01;
    private RichGridCell wsGrid02;
    private RichGridCell wsGrid03;
    private RichGridCell wsGrid11;
    private RichGridCell wsGrid12;
    private RichGridCell wsGrid13;
    private RichGridCell wsGrid21;
    private RichGridCell wsGrid22;
    private RichGridCell wsGrid23;


    private RichGridCell wsGrid31;
    private RichGridCell wsGrid32;


    private RichGridCell wsGrid33;
    private RichGridCell wsGrid41;
    private RichGridCell wsGrid42;
    private RichGridCell wsGrid43;
    private RichGridCell wsGrid51;
    private RichGridCell wsGrid52;
    private RichGridCell wsGrid53;
    private RichGridCell wsGrid61;
    private RichGridCell wsGrid62;
    private RichGridCell wsGrid63;
    private String status;
    private RichPoll pollLstnr11;
    private RichPoll pollLstnr12;
    private RichPoll pollLstnr21;
    private RichPoll pollLstnr22;
    private int count1 = 0;
    private int count2 = 0;
    private int count3 = 0;
    private int count4 = 0;
    private int count5 = 0;


    private RichPoll pollLstnr13;
    private RichPoll pollLstnr23;


    private RichPoll pollLstnr53;
    private RichPoll pollLstnr33;
    private RichPoll pollLstnr43;

    private RichPoll pollLstnr31;
    private RichPoll pollLstnr32;
    private RichPoll pollLstnr41;
    private RichPoll pollLstnr42;
    private RichPoll pollLstnr51;
    private RichPoll pollLstnr52;
    private Date dateAfterAdd1 = null;
    private Date dateAfterAdd2 = null;
    private Date dateAfterAdd3 = null;
    private Date dateAfterAdd4 = null;
    private Date dateAfterAdd5 = null;

    private boolean tenSeconds1 = true;
    private boolean tenSeconds2 = true;
    private boolean tenSeconds3 = true;
    private boolean tenSeconds4 = true;
    private boolean tenSeconds5 = true;
    private String next_url1[] = new String[100000];
    private String proUid[] = new String[100000];
    private String ref_IdS12[] = new String[100];

    private String urlValue = null;
    private List<String> reorderedComponentList = new ArrayList<String>();
    private List<String> reorderedComponentList1 = new ArrayList<String>();
    private List<String> reorderedComponentList2 = new ArrayList<String>();
    private String ref_id_new = null;
    private int m1 = 0;
    private int m2 = 0;
    private int m3 = 0;
    private int m4 = 0;
    private int m5 = 0;
    private int u1 = 0;
    private int u2 = 0;
    private int u3 = 0;
    private int u4 = 0;
    private int u5 = 0;
    private int t1 = 0;
    private int t2 = 0;
    private int t3 = 0;
    private int t4 = 0;
    private int t5 = 0;
    private int genUid =35;
    private int m=0;
    private String workFlowId = null;
    
    private RichPoll pollLstnr24;
    private RichPoll pollLstnr34;
    private RichPoll pollLstnr44;
    private RichPoll pollLstnr54;
    private int countT11 = 0;
    private  int countT21 = 0;
    private int countT31 = 0;
    private int countT41 = 0;
    private int countT51 = 0;
    private RichButton arrangeMachines;
    private RichButton machinesArranged;
    private RichInputText noOfP;
    private int partsQty;
    private String flow_pattern;
    private int inv;
    private RichButton stopWFBinding;
    private RichPoll pollLstnr25;
    private RichPoll pollLstnr26;
    private RichPanelGroupLayout outTemp2;
    private RichPanelGroupLayout outTemp3;
    private RichPoll pollLstnr35;
    private RichPoll pollLstnr36;
    private RichPanelGroupLayout outTemp4;
    private RichPoll pollLstnr45;
    private RichPoll pollLstnr46;
    private RichPanelGroupLayout outTemp5;
    private RichPoll pollLstnr55;
    private RichPoll pollLstnr56;
    private String processUid;
    private String mat_id;
    private RichInputText refIdBinding1;


    public UserBean() {
        BindingContext ctx = BindingContext.getCurrent();
        DCBindingContainer bc = (DCBindingContainer) ctx.getCurrentBindingsEntry();
        DCIteratorBinding iterator = bc.findIteratorBinding("DnsVO1Iterator");
        ViewObject dnsView = iterator.getViewObject();
        dnsView.executeQuery();
        Row r = iterator.getCurrentRow();
        urlValue = (String)r.getAttribute("Url");

    }

    public void loadWorkflow(ActionEvent actionEvent) throws InterruptedException, ParseException, IOException,
                                                             NoSuchMethodException, IllegalAccessException,
                                                             InvocationTargetException {
        UIComponent dropComponentParent = wsGrid02.getParent();

        UIComponent dropComponentParent1 = wsGrid03.getParent();
        UIComponent dropComponentParent2 = wsGrid01.getParent();
        reorderedComponentList.clear();
        reorderedComponentList1.clear();
        reorderedComponentList2.clear();
        reorderedComponentList.add("gc8");
        reorderedComponentList1.add("gc15");
        reorderedComponentList2.add("gc22");
        inv = 0;
        i = 0;
        numberOfParts = String.valueOf(i);
        this.wsGrid11.setRendered(false);
        this.wsGrid12.setRendered(false);
        this.wsGrid13.setRendered(false);
        this.wsGrid21.setRendered(false);
        this.wsGrid22.setRendered(false);
        this.wsGrid23.setRendered(false);
        this.wsGrid31.setRendered(false);
        this.wsGrid32.setRendered(false);
        this.wsGrid33.setRendered(false);
        this.wsGrid41.setRendered(false);
        this.wsGrid42.setRendered(false);
        this.wsGrid43.setRendered(false);
        this.wsGrid51.setRendered(false);
        this.wsGrid52.setRendered(false);
        this.wsGrid53.setRendered(false);
        String methodStart = "loadProcess";
        Method method = getClass().getMethod(methodStart);
        method.invoke(this);
        if (flow_pattern != null) {
            machines = flow_pattern.split(",");
            int no_of_machines = machines.length;

            for (int i = 0; i < no_of_machines; i++) {

                if (machines[i].equalsIgnoreCase("Drilling")) {
                    this.wsGrid11.setRendered(true);
                    this.wsGrid12.setRendered(true);
                    this.wsGrid13.setRendered(true);
                    reorderedComponentList.add("gc9");
                    reorderedComponentList1.add("gc16");
                    reorderedComponentList2.add("gc3");
                    if (i == 0) {
                        t1 = 10;
                    } else if (i == 1) {
                        t1 = 9;
                    } else if (i == 2) {
                        t1 = 8;
                    } else if (i == 3) {
                        t1 = 7;
                    } else if (i == 4) {
                        t1 = 6;
                    }


                } else if (machines[i].equalsIgnoreCase("Turning")) {
                    this.wsGrid21.setRendered(true);
                    this.wsGrid22.setRendered(true);
                    this.wsGrid23.setRendered(true);
                    reorderedComponentList.add("gc10");
                    reorderedComponentList1.add("gc17");
                    reorderedComponentList2.add("gc23");
                    if (i == 0) {
                        t2 = 10;
                    } else if (i == 1) {
                        t2 = 9;
                    } else if (i == 2) {
                        t2 = 8;
                    } else if (i == 3) {
                        t2 = 7;
                    } else if (i == 4) {
                        t2 = 6;
                    }

                } else if (machines[i].equalsIgnoreCase("Painting")) {
                    this.wsGrid31.setRendered(true);
                    this.wsGrid32.setRendered(true);
                    this.wsGrid33.setRendered(true);
                    reorderedComponentList.add("gc11");
                    reorderedComponentList1.add("gc18");
                    reorderedComponentList2.add("gc25");
                    if (i == 0) {
                        t3 = 10;
                    } else if (i == 1) {
                        t3 = 9;
                    } else if (i == 2) {
                        t3 = 8;
                    } else if (i == 3) {
                        t3 = 7;
                    } else if (i == 4) {
                        t3 = 6;
                    }


                } else if (machines[i].equalsIgnoreCase("Labelling")) {
                    this.wsGrid41.setRendered(true);
                    this.wsGrid42.setRendered(true);
                    this.wsGrid43.setRendered(true);
                    reorderedComponentList.add("gc12");
                    reorderedComponentList1.add("gc19");
                    reorderedComponentList2.add("gc24");
                    if (i == 0) {
                        t4 = 10;
                    } else if (i == 1) {
                        t4 = 9;
                    } else if (i == 2) {
                        t4 = 8;
                    } else if (i == 3) {
                        t4 = 7;
                    } else if (i == 4) {
                        t4 = 6;
                    }

                } else if (machines[i].equalsIgnoreCase("Packaging")) {
                    this.wsGrid51.setRendered(true);
                    this.wsGrid52.setRendered(true);
                    this.wsGrid53.setRendered(true);
                    reorderedComponentList.add("gc13");
                    reorderedComponentList1.add("gc20");
                    reorderedComponentList2.add("gc5");
                    if (i == 0) {
                        t5 = 10;
                    } else if (i == 1) {
                        t5 = 9;
                    } else if (i == 2) {
                        t5 = 8;
                    } else if (i == 3) {
                        t5 = 7;
                    } else if (i == 4) {
                        t5 = 6;
                    }
                }
            }

            reorderedComponentList.add("gc14");
            reorderedComponentList1.add("gc21");
            reorderedComponentList2.add("gc7");

            this.wsGrid01.setRendered(true);
            this.wsGrid02.setRendered(true);
            this.wsGrid03.setRendered(true);
            this.wsGrid61.setRendered(true);
            this.wsGrid62.setRendered(true);
            this.wsGrid63.setRendered(true);
            //            status = (String) jsonObject.get("STATUS");


            FacesContext fctx = FacesContext.getCurrentInstance();
            ReorderChildrenComponentChange reorderedChildChange =
                new ReorderChildrenComponentChange(reorderedComponentList);
            reorderedChildChange.changeComponent(dropComponentParent);
            ChangeManager cm = null;
            cm = RequestContext.getCurrentInstance().getChangeManager();
            cm.addComponentChange(fctx, dropComponentParent, reorderedChildChange);
            AdfFacesContext adfFacesCtx = AdfFacesContext.getCurrentInstance();
            adfFacesCtx.addPartialTarget(dropComponentParent);

            FacesContext fctx1 = FacesContext.getCurrentInstance();
            ReorderChildrenComponentChange reorderedChildChange1 =
                new ReorderChildrenComponentChange(reorderedComponentList1);
            reorderedChildChange1.changeComponent(dropComponentParent1);
            ChangeManager cm1 = null;
            cm1 = RequestContext.getCurrentInstance().getChangeManager();
            cm1.addComponentChange(fctx1, dropComponentParent1, reorderedChildChange1);
            AdfFacesContext.getCurrentInstance().addPartialTarget(dropComponentParent1);


            FacesContext fctx2 = FacesContext.getCurrentInstance();
            ReorderChildrenComponentChange reorderedChildChange2 =
                new ReorderChildrenComponentChange(reorderedComponentList2);
            reorderedChildChange2.changeComponent(dropComponentParent2);
            ChangeManager cm2 = null;
            cm2 = RequestContext.getCurrentInstance().getChangeManager();
            cm2.addComponentChange(fctx2, dropComponentParent2, reorderedChildChange2);
            AdfFacesContext.getCurrentInstance().addPartialTarget(dropComponentParent2);

            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.addPartialTarget(buttonContainerBinding);
            this.arrangeMachines.setDisabled(false);
            this.loadWorkflowBinding.setDisabled(true);
            this.clearWorkflowBinding.setDisabled(false);
            this.startWorkflowBinding.setDisabled(false);
            this.noOfP.setShowRequired(true);
            this.noOfP.setRequired(true); 
            AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
            AdfFacesContext.getCurrentInstance().addPartialTarget(buttonContainerBinding);


        }
        
    }

    public void startProcess() throws ParseException {
        m1 = 0;
        m2 = 0;
        m3 = 0;
        m4 = 0;
        m5 = 0;
        u1 = 0;
        u2 = 0;
        u3 = 0;
        u4 = 0;
        u5 = 0;

        z[m1] = 1;
        z[m2] = 1;
        z[m3] = 1;
        z[m4] = 1;
        z[m5] = 1;

        count1 = 0;
        count2 = 0;
        count3 = 0;
        count4 = 0;
        count5 = 0;
       String genUid1 = (String) this.getRefIdBinding1().getValue();
        genUid=Integer.parseInt(genUid1);
        processUid= this.genProUid();
        mat_id = (String) this.getRefIdBinding().getValue();

        String ref_id_new1 ="ID="+processUid +"&materialid="+mat_id;

        HttpRestClient httpRestClient = new HttpRestClient();
        httpRestClient.connectToServer("http://" + urlValue + ":7077/callesbservice", "startprocesswithrfid1");
        String jsonString = httpRestClient.sendPOSTRequest(ref_id_new1);

        JSONParser parser = new JSONParser();

        JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
        next_url1[u1] = (String) jsonObject.get("URL");
        System.out.println("Value of next_url1[u1] in load workflow" + next_url1[u1]);
        workFlowId = (String) jsonObject.get("WF_ID");
        
        ref_IdS12[u1] = (String) jsonObject.get("ID");
        flow_pattern = (String) jsonObject.get("flow_pattern");
        inputP01 = (String) jsonObject.get("I_PARAM1");
        inputP02 = (String) jsonObject.get("I_PARAM2");
        inputP03 = (String) jsonObject.get("I_PARAM3");
        inputP04 = (String) jsonObject.get("I_PARAM4");
        status = (String) jsonObject.get("STATUS");


    }
    
    public void loadProcess() throws ParseException {
        
            String ref_id = (String) this.getRefIdBinding().getValue();

            ref_id_new = "materialid=" + ref_id;

            HttpRestClient httpRestClient = new HttpRestClient();
            httpRestClient.connectToServer("http://" + urlValue + ":7077/callesbservice", "startprocesswithmatid");
            String jsonString = httpRestClient.sendPOSTRequest(ref_id_new);

            JSONParser parser = new JSONParser();

            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);

            flow_pattern = (String) jsonObject.get("flow_pattern");
        
        
        }
    public String genProUid(){
          genUid++;
        String proUidgen="2000"+genUid;
        return proUidgen;
        }

    public void startWorkflow(ActionEvent actionEvent) throws ParseException, IllegalAccessException,
                                                              InvocationTargetException, NoSuchMethodException {
        noOfP1 = 0;
       
            String methodStart = "startProcess";
            Method method = getClass().getMethod(methodStart);
            method.invoke(this);
   
        String partsQtyS = (String) this.noOfP.getValue();
        if (partsQtyS != null) {
            partsQty = (Integer.parseInt(partsQtyS)) - 1;
            inv = inv + partsQty;
            partsQty=inv;
        } else {
            
            return;
        }
        
        if (status.contains("Process")) {
            if (machines[0].equalsIgnoreCase("Drilling")) {
                this.pollLstnr11.setRendered(true);
                this.pollLstnr12.setRendered(true);
                proUid[u1]=processUid;
                myProcessingUnid1=proUid[u1];
                inPutDrill(inputP01, inputP02, inputP03, inputP04);
                this.workSt1Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");


            } else if (machines[0].equalsIgnoreCase("Turning")) {
                this.pollLstnr21.setRendered(true);
                this.pollLstnr22.setRendered(true);
                proUid[u2]=processUid;
                myProcessingUnid2=proUid[u2];
                inPutTurn(inputP01, inputP02, inputP03, inputP04);
                this.workSt2Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

            } else if (machines[0].equalsIgnoreCase("Painting")) {
                this.pollLstnr31.setRendered(true);
                this.pollLstnr32.setRendered(true);
                proUid[u3]=processUid;
                myProcessingUnid3=proUid[u3];
                inPutPaint(inputP01, inputP02, inputP03, inputP04);
                this.workSt3Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
            } else if (machines[0].equalsIgnoreCase("Labelling")) {
                this.pollLstnr41.setRendered(true);
                this.pollLstnr42.setRendered(true);
                proUid[u4]=processUid;
                myProcessingUnid4=proUid[u4];
                inPutLabel(inputP01, inputP02, inputP03, inputP04);
                this.workSt4Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
            } else if (machines[0].equalsIgnoreCase("Packaging")) {
                this.pollLstnr51.setRendered(true);
                this.pollLstnr52.setRendered(true);
                proUid[u5]=processUid;
                myProcessingUnid5=proUid[u1];
                inPutPack(inputP01, inputP02, inputP03, inputP04);
                this.workSt5Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
            }


        }
        this.clearWorkflowBinding.setDisabled(true);
        this.startWorkflowBinding.setDisabled(true);
        this.stopWFBinding.setDisabled(false);
        this.noOfP.setShowRequired(false);
        this.noOfP.setRequired(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(buttonContainerBinding);
    }

    public void inPutDrill(String i1, String i2, String i3, String i4) {
        inputP11 = i1;
        inputP12 = "Depth:" + i2;
        inputP13 = "Rad:" + i3;
        inputP14 = "St" + i4;
        this.dnArrow1.setVisible(true);
        this.inParams1.setVisible(true);
        this.pollLstnr16.setRendered(true);
        this.outParams1.setVisible(false);
        this.outTemp1.setVisible(false);
    }
    
    
    
    public void inPutTurn(String i1, String i2, String i3, String i4) {
        inputP21 = i1;
        inputP22 = "Depth:" + i2;
        inputP23 = "Rad:" + i3;
        inputP24 = "St" + i4;
        this.dnArrow2.setVisible(true);
        this.inParams2.setVisible(true);
        this.pollLstnr26.setRendered(true);
        this.outParams2.setVisible(false);
        this.outTemp2.setVisible(false);

    }

    public void inPutPaint(String i1, String i2, String i3, String i4) {
        inputP31 = i1;
        inputP32 = "Depth:" + i2;
        inputP33 = "Rad:" + i3;
        inputP34 = "St" + i4;
        this.dnArrow3.setVisible(true);
        this.inParams3.setVisible(true);
        this.pollLstnr36.setRendered(true);
        this.outParams3.setVisible(false);
        this.outTemp3.setVisible(false);

    }

    public void inPutLabel(String i1, String i2, String i3, String i4) {
        inputP41 = i1;
        inputP42 = "Depth:" + i2;
        inputP43 = "Rad:" + i3;
        inputP44 = "St:" + i4;
        this.dnArrow4.setVisible(true);
        this.inParams4.setVisible(true);
        this.pollLstnr46.setRendered(true);
        this.outParams4.setVisible(false);
        this.outTemp4.setVisible(false);

    }

    public void inPutPack(String i1, String i2, String i3, String i4) {
        inputP51 = i1;
        inputP52 = "Depth:" + i2;
        inputP53 = "Rad:" + i3;
        inputP54 = "St:" + i4;
        this.dnArrow5.setVisible(true);
        this.inParams5.setVisible(true);
        this.pollLstnr56.setRendered(true);
        this.outParams5.setVisible(false);
        this.outTemp5.setVisible(false);

    }


    public void machArranLstnr(ActionEvent actionEvent) throws IOException {
        File file = new File("C:\\Nilesh\\Videos/drilling.mp4");
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);

        }
        file = new File("C:\\Nilesh\\Videos/Turning.bmp");


        if (file.exists()) {
            desktop.open(file);

        }
        file = new File("C:\\Nilesh\\Videos/Painting.jpg");

        if (file.exists()) {
            desktop.open(file);

        }
        file = new File("C:\\Nilesh\\Videos/Labelling.txt");

        if (file.exists()) {
            desktop.open(file);

        }
        file = new File("C:\\Nilesh\\Videos/Packaging.pdf");

        if (file.exists()) {
            desktop.open(file);

        }
        this.machinesArranged.setDisabled(false);
        this.arrangeMachines.setDisabled(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(buttonContainerBinding);
    }

    public void arrangeDoneLstnr(ActionEvent actionEvent) throws IOException {
        Runtime.getRuntime().exec("taskkill /IM mpc-hc.exe");
        Runtime.getRuntime().exec("taskkill /IM notepad++.exe");
        Runtime.getRuntime().exec("taskkill /IM OIS.EXE");
        Runtime.getRuntime().exec("taskkill /IM notepad.exe");
        Runtime.getRuntime().exec("taskkill /IM AcroRd32.exe");
        this.machinesArranged.setDisabled(true);
        this.startWorkflowBinding.setDisabled(false);
        this.noOfP.setShowRequired(true);
        this.noOfP.setRequired(true);    
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(buttonContainerBinding);

    }

    public void stopWF(ActionEvent actionEvent) {
        count1 = partsQty;
        count2 = partsQty;
        count3 = partsQty;
        count4 = partsQty;
        count5 = partsQty;
        this.clearWorkflowBinding.setDisabled(false);
        this.startWorkflowBinding.setDisabled(false);
        this.stopWFBinding.setDisabled(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(buttonContainerBinding);

    }


    public void workSt1PollLstnr11(PollEvent pollEvent) throws IOException, InterruptedException, ParseException,
                                                               ClassNotFoundException {
        Calendar calobj = Calendar.getInstance();

        Date currentDate1 = calobj.getTime();

        if (tenSeconds1) {
            calobj.add(Calendar.SECOND, t1);
            dateAfterAdd1 = calobj.getTime();
            tenSeconds1 = false;
        }
        if (currentDate1.after(dateAfterAdd1)) {
            this.workSt1Block.setInlineStyle("height:95px; width:95px; background-color:#B2FF66;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
            this.pollLstnr11.setRendered(false);
            this.pollLstnr13.setRendered(true);
            this.pollLstnr15.setRendered(false);
            this.outTemp1.setVisible(false);
            this.upArrow1.setVisible(false);
            tenSeconds1 = true;
            int iparam151 = 10;
            System.out.println("Value of next_url1[u1] in poll listnr11" + next_url1[u1]);
            String ref_id_new1 =
                "URL=" + next_url1[u1] + "&wf_id=" + workFlowId + "&rf_id=" +  ref_IdS12[u1] + "&q_param1=" + iparam151 +
                "&q_param2=5&q_param3=5&q_param4=0";
            HttpRestClient httpRestClient1 = new HttpRestClient();
            httpRestClient1.connectToServer("http://" + urlValue + ":7077/callesbservice", "sendqualityparameters");
            String jsonString1 = httpRestClient1.sendPOSTRequest(ref_id_new1);

            JSONParser parser1 = new JSONParser();

            JSONObject jsonObject1 = (JSONObject) parser1.parse(jsonString1);

            next_url1[u1] = (String) jsonObject1.get("next_url");
            String status1 = (String) jsonObject1.get("next_status");

            String in1 = (String) jsonObject1.get("next_param1");


            String in2 = (String) jsonObject1.get("next_param2");


            String in3 = (String) jsonObject1.get("next_param3");


            String in4 = (String) jsonObject1.get("next_param4");


            System.out.println("Value of u1 :" + u1);
            System.out.println("Value of m1 :" + m1);
            System.out.println("Value of z[m1] is :" + z[m1]);
            System.out.println("Value of next_url1[u1] :" + next_url1[u1]);
            if (status1.contains("Process") && z[m1] < machines.length) {
                outputP11 = "Dep:10";
                outputP12 = "Radi:5";
                outputP13 = "Strngth:5";
                outputP14 = "AvgTemp:2";
                this.outParams1.setVisible(true);
                this.upArrow1.setVisible(true);
                if (machines[z[m1]].equalsIgnoreCase("Turning")) {
                    this.pollLstnr21.setRendered(true);
                    this.pollLstnr22.setRendered(true);
                    inPutTurn(in1, in2, in3, in4);
                    myProcessingUnid2=proUid[u1];
                    this.workSt2Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                }


                else if (machines[z[m1]].equalsIgnoreCase("Painting")) {
                    this.pollLstnr31.setRendered(true);
                    this.pollLstnr32.setRendered(true);
                    inPutPaint(in1, in2, in3, in4);
                    myProcessingUnid3=proUid[u1];
                    this.workSt3Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                }

                else if (machines[z[m1]].equalsIgnoreCase("Labelling")) {
                    this.pollLstnr41.setRendered(true);
                    this.pollLstnr42.setRendered(true);
                    inPutLabel(in1, in2, in3, in4);
                    myProcessingUnid4=proUid[u1];
                    this.workSt4Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                } else if (machines[z[m1]].equalsIgnoreCase("Packaging")) {
                    this.pollLstnr51.setRendered(true);
                    this.pollLstnr52.setRendered(true);
                    myProcessingUnid5=proUid[u1];
                    inPutPack(in1, in2, in3, in4);
                    this.workSt5Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                }

            }
            if (machines.length == z[m1]) {
                i = i + 1;
                noOfP1++;
                this.truck.setVisible(false);
                numberOfParts = String.valueOf(i);
                if (noOfP1 == (partsQty + 1)) {
                    this.clearWorkflowBinding.setDisabled(false);
                    this.startWorkflowBinding.setDisabled(false);
                    this.stopWFBinding.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(buttonContainerBinding);
                }
                
                if (i==4){
                    this.truck.setVisible(true);
                    i=0;
                    }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
            z[m1]++;
            m1++;

        }
    }


    public void workSt1PollLstnr12(PollEvent pollEvent) throws ParseException {
        String ref_id_new1 = "URL=" + next_url1[u1] + "&status=Processing";
        HttpRestClient httpRestClient1 = new HttpRestClient();
        httpRestClient1.connectToServer("http://" + urlValue + ":7077/callesbservice", "sendstatus");
        String jsonString1 = httpRestClient1.sendPOSTRequest(ref_id_new1);
        JSONParser parser1 = new JSONParser();

        JSONObject jsonObject1 = (JSONObject) parser1.parse(jsonString1);
        String message = (String) jsonObject1.get("SEND_CONFIRMATION");

        if (message != null) {
            this.workSt1Block.setInlineStyle("height:95px; width:95px;;background-color:Orange;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

        }
        this.pollLstnr12.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);


    }

    public void workSt1PollLstnr13(PollEvent pollEvent) throws ParseException {

        myProcessingUnid1=null;
        this.workSt1Block.setInlineStyle("height:95px; width:95px; background-color:#C0C0C0;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
        this.pollLstnr13.setRendered(false);
        this.upArrow1.setVisible(false);
        this.outParams1.setVisible(false);
        u1++;
        if (count1 < partsQty && machines[0].equalsIgnoreCase("Drilling")) {
            count1++;
            processUid=this.genProUid();
            String ref_id_new1 ="ID="+processUid +"&materialid="+mat_id;
            HttpRestClient httpRestClient = new HttpRestClient();
            httpRestClient.connectToServer("http://" + urlValue + ":7077/callesbservice", "startprocesswithrfid1");
            String jsonString = httpRestClient.sendPOSTRequest(ref_id_new1);

            JSONParser parser = new JSONParser();

            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            next_url1[u1] = (String) jsonObject.get("URL");
            proUid[u1]=(String)jsonObject.get("ID");
            ref_IdS12[u1]=proUid[u1];
            status = (String) jsonObject.get("STATUS");
            if (status.contains("Process")) {
                this.pollLstnr11.setRendered(true);
                this.pollLstnr12.setRendered(true);
                inputP01 = (String) jsonObject.get("I_PARAM1");
                inputP02 = (String) jsonObject.get("I_PARAM2");
                inputP03 = (String) jsonObject.get("I_PARAM3");
                inputP04 = (String) jsonObject.get("I_PARAM4");
                inPutDrill(inputP01, inputP02, inputP03, inputP04);
                myProcessingUnid1= proUid[u1];
                this.workSt1Block.setInlineStyle("height:95px; width:95px;background-color:Yellow;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
                z[m1] = 1;
                inv--;

            }
        }

        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);


    }


    public void workSt1PollLstnr15(PollEvent pollEvent) {

        int randomTemp = (int) (Math.random() * (30 - 20) + 20);
        int randomHumid = (int) (Math.random() * (20 - 10) + 10);
        int randomPressure = (int) (Math.random() * (110 - 90) + 90);
        outTemp11 = "Temp:" + String.valueOf(randomTemp);
        outHumid11 = "Humid:" + String.valueOf(randomHumid);
        outRandomP1 = "Pressure:" + String.valueOf(randomPressure);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
    }

    public void workSt1PollLstnr16(PollEvent pollEvent) {
        if (countT11 == 10) {
            this.inParams1.setVisible(false);
            this.dnArrow1.setVisible(false);
            this.pollLstnr15.setRendered(true);
            this.upArrow1.setVisible(true);
            this.outTemp1.setVisible(true);
            this.pollLstnr16.setRendered(false);
            countT11 = 0;
            AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
        } else {
            countT11++;
        }

    }


    public void workSt1PollLstnr21(PollEvent pollEvent) throws IOException, InterruptedException, ParseException,
                                                               ClassNotFoundException {


        Calendar calobj = Calendar.getInstance();

        Date currentDate1 = calobj.getTime();

        if (tenSeconds2) {
            calobj.add(Calendar.SECOND, t2);
            dateAfterAdd2 = calobj.getTime();
            tenSeconds2 = false;
        }
        if (currentDate1.after(dateAfterAdd2)) {
            this.workSt2Block.setInlineStyle("height:95px; width:95px; background-color:#B2FF66;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
            this.pollLstnr21.setRendered(false);
            this.pollLstnr23.setRendered(true);
            this.pollLstnr25.setRendered(false);
            this.outTemp2.setVisible(false);
            this.upArrow2.setVisible(false);
            tenSeconds2 = true;
            String ref_id_new1 =
                "URL=" + next_url1[u2] + "&wf_id=" + workFlowId + "&rf_id=" + ref_IdS12[u2] +
                "&q_param1=10&q_param2=5&q_param3=5&q_param4=0";
            System.out.println("Value of ref_id_new1 for poll21 is :" + ref_id_new1);
            HttpRestClient httpRestClient1 = new HttpRestClient();
            httpRestClient1.connectToServer("http://" + urlValue + ":7077/callesbservice", "sendqualityparameters");
            String jsonString1 = httpRestClient1.sendPOSTRequest(ref_id_new1);

            JSONParser parser1 = new JSONParser();

            JSONObject jsonObject1 = (JSONObject) parser1.parse(jsonString1);

            next_url1[u2] = (String) jsonObject1.get("next_url");
            String status1 = (String) jsonObject1.get("next_status");
            System.out.println("Value of u2 :" + u2);
            System.out.println("Value of m2 :" + m2);
            System.out.println("value of z[m2] is" + z[m2]);
            System.out.println("value of next_url1[u2]" + next_url1[u2]);

            String in1 = (String) jsonObject1.get("next_param1");


            String in2 = (String) jsonObject1.get("next_param2");


            String in3 = (String) jsonObject1.get("next_param3");


            String in4 = (String) jsonObject1.get("next_param4");

            if (status1.contains("Process") && z[m2] < machines.length) {
                outputP21 = "Dep:10";
                outputP22 = "Radi:5";
                outputP23 = "Strngth:5";
                outputP24 = "AvgTemp:2";
                this.outParams2.setVisible(true);
                this.upArrow2.setVisible(true);
                if (machines[z[m2]].equalsIgnoreCase("Drilling")) {
                    this.pollLstnr11.setRendered(true);
                    this.pollLstnr12.setRendered(true);
                    myProcessingUnid1=proUid[u2];
                    inPutDrill(in1, in2, in3, in4);
                    this.workSt1Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
                }

                else if (machines[z[m2]].equalsIgnoreCase("Painting")) {
                    this.pollLstnr31.setRendered(true);
                    this.pollLstnr32.setRendered(true);
                    myProcessingUnid3=proUid[u2];
                    inPutPaint(in1, in2, in3, in4);
                    this.workSt3Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
                }

                else if (machines[z[m2]].equalsIgnoreCase("Labelling")) {
                    this.pollLstnr41.setRendered(true);
                    this.pollLstnr42.setRendered(true);
                    myProcessingUnid4=proUid[u2];
                    inPutLabel(in1, in2, in3, in4);
                    this.workSt4Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                } else if (machines[z[m2]].equalsIgnoreCase("Packaging")) {
                    this.pollLstnr51.setRendered(true);
                    this.pollLstnr52.setRendered(true);
                    myProcessingUnid5=proUid[u2];
                    inPutPack(in1, in2, in3, in4);
                    this.workSt5Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                }


            }
            if (machines.length == z[m2]) {
                i = i + 1;
                noOfP1++;
                this.truck.setVisible(false);
                numberOfParts = String.valueOf(i);
                if (noOfP1 == (partsQty + 1)) {
                    this.clearWorkflowBinding.setDisabled(false);
                    this.startWorkflowBinding.setDisabled(false);
                    this.stopWFBinding.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(buttonContainerBinding);
                }
                if (i==4){
                    this.truck.setVisible(true);
                    i=0;
                    }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
            z[m2]++;
            m2++;
        }


    }


    public void workSt1PollLstnr22(PollEvent pollEvent) throws ParseException {
        String ref_id_new1 = "URL=" + next_url1[u2] + "&status=Processing";
        HttpRestClient httpRestClient1 = new HttpRestClient();
        httpRestClient1.connectToServer("http://" + urlValue + ":7077/callesbservice", "sendstatus");
        String jsonString1 = httpRestClient1.sendPOSTRequest(ref_id_new1);

        JSONParser parser1 = new JSONParser();

        JSONObject jsonObject1 = (JSONObject) parser1.parse(jsonString1);
        String message = (String) jsonObject1.get("SEND_CONFIRMATION");

        if (message != null) {
            this.workSt2Block.setInlineStyle("height:95px; width:95px;;background-color:Orange;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

        }
        this.pollLstnr22.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);


    }

    public void workSt1PollLstnr23(PollEvent pollEvent) throws ParseException {

        myProcessingUnid2=null;
        this.workSt2Block.setInlineStyle("height:95px; width:95px; background-color:#C0C0C0;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
        this.pollLstnr23.setRendered(false);
        this.upArrow2.setVisible(false);
        this.outParams2.setVisible(false);
        u2++;
        if (count2 < partsQty && machines[0].equalsIgnoreCase("Turning")) {
            count2++;
            processUid=this.genProUid();
            String ref_id_new1 ="ID="+processUid +"&materialid="+mat_id;
            HttpRestClient httpRestClient = new HttpRestClient();
            httpRestClient.connectToServer("http://" + urlValue + ":7077/callesbservice", "startprocesswithrfid1");
            String jsonString = httpRestClient.sendPOSTRequest(ref_id_new1);

            JSONParser parser = new JSONParser();

            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            next_url1[u2] = (String) jsonObject.get("URL");
            proUid[u2]=(String)jsonObject.get("ID");
            ref_IdS12[u2]=proUid[u2];
            System.out.println(" Value inside count2 for next_url1[u2] is :" + next_url1[u2]);
            String status2 = (String) jsonObject.get("STATUS");
            System.out.println(" Value inside count2 for status is :" + status2);
            if (status2.contains("Process")) {
                this.pollLstnr21.setRendered(true);
                this.pollLstnr22.setRendered(true);
                inputP01 = (String) jsonObject.get("I_PARAM1");
                inputP02 = (String) jsonObject.get("I_PARAM2");
                inputP03 = (String) jsonObject.get("I_PARAM3");
                inputP04 = (String) jsonObject.get("I_PARAM4");
                inPutTurn(inputP01, inputP02, inputP03, inputP04);
                myProcessingUnid2= proUid[u2];
                this.workSt2Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
                z[m2] = 1;
                inv--;
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);

    }

    public void workSt1PollLstnr25(PollEvent pollEvent) {
        int randomTemp = (int) (Math.random() * (30 - 20) + 20);
        int randomHumid = (int) (Math.random() * (20 - 10) + 10);
        int randomPressure = (int) (Math.random() * (110 - 90) + 90);
        outTemp21 = "Temp:" + String.valueOf(randomTemp);
        outHumid21 = "Humid:" + String.valueOf(randomHumid);
        outRandomP2 = "Pressure:" + String.valueOf(randomPressure);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
    }
    
    public void workSt1PollLstnr26(PollEvent pollEvent) {
        if (countT21 == 10) {
            this.inParams2.setVisible(false);
            this.dnArrow2.setVisible(false);
            this.pollLstnr25.setRendered(true);
            this.upArrow2.setVisible(true);
            this.outTemp2.setVisible(true);
            this.pollLstnr26.setRendered(false);
            countT21 = 0;
            AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
        } else {
            countT21++;
        }

    }


    public void workSt1PollLstnr31(PollEvent pollEvent) throws IOException, InterruptedException, ParseException,
                                                               ClassNotFoundException {


        Calendar calobj = Calendar.getInstance();

        Date currentDate1 = calobj.getTime();

        if (tenSeconds3) {
            calobj.add(Calendar.SECOND, t3);
            dateAfterAdd3 = calobj.getTime();
            tenSeconds3 = false;
        }
        if (currentDate1.after(dateAfterAdd3)) {
            this.workSt3Block.setInlineStyle("height:95px; width:95px; background-color:#B2FF66;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
            this.pollLstnr31.setRendered(false);
            this.pollLstnr33.setRendered(true);
            this.pollLstnr35.setRendered(false);
            this.outTemp3.setVisible(false);
            this.upArrow3.setVisible(false);
            tenSeconds3 = true;
            String ref_id_new1 =
                "URL=" + next_url1[u3] + "&wf_id=" + workFlowId + "&rf_id=" + ref_IdS12[u3] +
                "&q_param1=10&q_param2=5&q_param3=5&q_param4=0";
            HttpRestClient httpRestClient1 = new HttpRestClient();
            httpRestClient1.connectToServer("http://" + urlValue + ":7077/callesbservice", "sendqualityparameters");
            String jsonString1 = httpRestClient1.sendPOSTRequest(ref_id_new1);

            JSONParser parser1 = new JSONParser();

            JSONObject jsonObject1 = (JSONObject) parser1.parse(jsonString1);
            String status1 = (String) jsonObject1.get("next_status");
            next_url1[u3] = (String) jsonObject1.get("next_url");
            String in1 = (String) jsonObject1.get("next_param1");


            String in2 = (String) jsonObject1.get("next_param2");


            String in3 = (String) jsonObject1.get("next_param3");


            String in4 = (String) jsonObject1.get("next_param4");

            System.out.println("Value of u3 :" + u3);
            System.out.println("Value of m3 :" + m3);
            System.out.println("value of z[m3] is" + z[m3]);
            System.out.println("Value of next_url1[u3]" + next_url1[u3]);

            if (status1.contains("Process") && z[m3] < machines.length) {
                outputP31 = "Dep:10";
                outputP32 = "Radi:5";
                outputP33 = "Strngth:5";
                outputP34 = "AvgTemp:2";
                this.outParams3.setVisible(true);
                this.upArrow3.setVisible(true);
                if (machines[z[m3]].equalsIgnoreCase("Turning")) {
                    this.pollLstnr21.setRendered(true);
                    this.pollLstnr22.setRendered(true);
                    myProcessingUnid2=proUid[u3];
                    inPutTurn(in1, in2, in3, in4);
                    this.workSt2Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
                }


                else if (machines[z[m3]].equalsIgnoreCase("Drilling")) {
                    this.pollLstnr11.setRendered(true);
                    this.pollLstnr12.setRendered(true);
                    myProcessingUnid1=proUid[u3];
                    inPutDrill(in1, in2, in3, in4);
                    this.workSt1Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                }

                else if (machines[z[m3]].equalsIgnoreCase("Labelling")) {
                    this.pollLstnr41.setRendered(true);
                    this.pollLstnr42.setRendered(true);
                    inPutLabel(in1, in2, in3, in4);
                    myProcessingUnid4=proUid[u3];
                    this.workSt4Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                } else if (machines[z[m3]].equalsIgnoreCase("Packaging")) {
                    this.pollLstnr51.setRendered(true);
                    this.pollLstnr52.setRendered(true);
                    myProcessingUnid5=proUid[u3];
                    inPutPack(in1, in2, in3, in4);
                    this.workSt5Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                }

            }
            if (machines.length == z[m3]) {
                i = i + 1;
                noOfP1++;
                this.truck.setVisible(false);
                numberOfParts = String.valueOf(i);
                if (noOfP1 == (partsQty + 1)) {
                    this.clearWorkflowBinding.setDisabled(false);
                    this.startWorkflowBinding.setDisabled(false);
                    this.stopWFBinding.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(buttonContainerBinding);
                }
                
                if (i==4){
                    this.truck.setVisible(true);
                    i=0;
                    }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
            z[m3]++;
            m3++;
        }


    }

    public void workSt1PollLstnr32(PollEvent pollEvent) throws ParseException {
        String ref_id_new1 = "URL=" + next_url1[u3] + "&status=Processing"; 
        HttpRestClient httpRestClient1 = new HttpRestClient();
        httpRestClient1.connectToServer("http://" + urlValue + ":7077/callesbservice", "sendstatus");
        String jsonString1 = httpRestClient1.sendPOSTRequest(ref_id_new1);
        JSONParser parser1 = new JSONParser();
        JSONObject jsonObject1 = (JSONObject) parser1.parse(jsonString1);
        String message = (String) jsonObject1.get("SEND_CONFIRMATION");

        if (message != null) {
            this.workSt3Block.setInlineStyle("height:95px; width:95px;;background-color:Orange;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

        }
        this.pollLstnr32.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);


    }


    public void workSt1PollLstnr33(PollEvent pollEvent) throws ParseException {
        myProcessingUnid3=null;
        this.workSt3Block.setInlineStyle("height:95px; width:95px; background-color:#C0C0C0;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
        this.pollLstnr33.setRendered(false);
        this.upArrow3.setVisible(false);
        this.outParams3.setVisible(false);
        u3++;
        if (count3 < partsQty && machines[0].equalsIgnoreCase("Painting")) {
            count3++;
            processUid=this.genProUid();
            String ref_id_new1 ="ID="+processUid +"&materialid="+mat_id;
            HttpRestClient httpRestClient = new HttpRestClient();
            httpRestClient.connectToServer("http://" + urlValue + ":7077/callesbservice", "startprocesswithrfid1");
            String jsonString = httpRestClient.sendPOSTRequest(ref_id_new1);

            JSONParser parser = new JSONParser();

            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            next_url1[u3] = (String) jsonObject.get("URL");
            proUid[u3]=(String)jsonObject.get("ID");
            ref_IdS12[u3]=proUid[u3];
            String status3 = (String) jsonObject.get("STATUS");
            System.out.println(" Value inside count3 for status is :" + next_url1[u3]);
            if (status3.contains("Process"))
                if (next_url1[u3] != null) {
                    this.pollLstnr31.setRendered(true);
                    this.pollLstnr32.setRendered(true);
                    inputP01 = (String) jsonObject.get("I_PARAM1");
                    inputP02 = (String) jsonObject.get("I_PARAM2");
                    inputP03 = (String) jsonObject.get("I_PARAM3");
                    inputP04 = (String) jsonObject.get("I_PARAM4");
                    inPutPaint(inputP01, inputP02, inputP03, inputP04);
                    myProcessingUnid3=proUid[u3];
                    this.workSt3Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
                    z[m3] = 1;
                    inv--;
                }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);

    }

    public void workSt1PollLstnr35(PollEvent pollEvent) {
        int randomTemp = (int) (Math.random() * (30 - 20) + 20);
        int randomHumid = (int) (Math.random() * (20 - 10) + 10);
        int randomPressure = (int) (Math.random() * (110 - 90) + 90);
        outTemp31 = "Temp:" + String.valueOf(randomTemp);
        outHumid31 = "Humid:" + String.valueOf(randomHumid);
        outRandomP3 = "Pressure:" + String.valueOf(randomPressure);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
    }
    
    public void workSt1PollLstnr36(PollEvent pollEvent) {
        if (countT31 == 10) {
            this.inParams3.setVisible(false);
            this.dnArrow3.setVisible(false);
            this.pollLstnr35.setRendered(true);
            this.upArrow3.setVisible(true);
            this.outTemp3.setVisible(true);
            this.pollLstnr36.setRendered(false);
            countT31 = 0;
            AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
        } else {
            countT31++;
        }

    }


    public void workSt1PollLstnr41(PollEvent pollEvent) throws IOException, InterruptedException, ParseException {


        Calendar calobj = Calendar.getInstance();

        Date currentDate1 = calobj.getTime();

        if (tenSeconds4) {
            calobj.add(Calendar.SECOND, t4);
            dateAfterAdd4 = calobj.getTime();
            tenSeconds4 = false;
        }
        if (currentDate1.after(dateAfterAdd4)) {
            this.workSt4Block.setInlineStyle("height:95px; width:95px; background-color:#B2FF66;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
            this.pollLstnr41.setRendered(false);
            this.pollLstnr43.setRendered(true);
            this.pollLstnr45.setRendered(false);
            this.outTemp4.setVisible(false);
            this.upArrow4.setVisible(false);
            tenSeconds4 = true;
            String ref_id_new1 =
                "URL=" + next_url1[u4] + "&wf_id=" + workFlowId + "&rf_id=" + ref_IdS12[u4] +
                "&q_param1=10&q_param2=5&q_param3=5&q_param4=0";
            HttpRestClient httpRestClient1 = new HttpRestClient();
            httpRestClient1.connectToServer("http://" + urlValue + ":7077/callesbservice", "sendqualityparameters");
            String jsonString1 = httpRestClient1.sendPOSTRequest(ref_id_new1);

            JSONParser parser1 = new JSONParser();

            JSONObject jsonObject1 = (JSONObject) parser1.parse(jsonString1);

            next_url1[u4] = (String) jsonObject1.get("next_url");
            String status1 = (String) jsonObject1.get("next_status");
            String in1 = (String) jsonObject1.get("next_param1");


            String in2 = (String) jsonObject1.get("next_param2");


            String in3 = (String) jsonObject1.get("next_param3");


            String in4 = (String) jsonObject1.get("next_param4");

            System.out.println("Value of u4 :" + u4);
            System.out.println("Value of m4 :" + m4);
            System.out.println("value of z[m4] is" + z[m4]);
            System.out.println("Value of next_url1[u4]" + next_url1[u4]);

            if (status1.contains("Process") && z[m4] < machines.length) {
                outputP41 = "Dep:10";
                outputP42 = "Radi:5";
                outputP43 = "Stngth:5";
                outputP44 = "AvgTemp:2";
                this.outParams4.setVisible(true);
                this.upArrow4.setVisible(true);
                if (machines[z[m4]].equalsIgnoreCase("Turning")) {
                    this.pollLstnr21.setRendered(true);
                    this.pollLstnr22.setRendered(true);
                    inPutTurn(in1, in2, in3, in4);
                    myProcessingUnid2=proUid[u4];
                    this.workSt2Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                }


                else if (machines[z[m4]].equalsIgnoreCase("Painting")) {
                    this.pollLstnr31.setRendered(true);
                    this.pollLstnr32.setRendered(true);
                    inPutPaint(in1, in2, in3, in4);
                    myProcessingUnid3=proUid[u4];
                    this.workSt3Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                }

                else if (machines[z[m4]].equalsIgnoreCase("Drilling")) {
                    this.pollLstnr11.setRendered(true);
                    this.pollLstnr12.setRendered(true);
                    inPutDrill(in1, in2, in3, in4);
                    myProcessingUnid1=proUid[u4];
                    this.workSt1Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                } else if (machines[z[m4]].equalsIgnoreCase("Packaging")) {
                    this.pollLstnr51.setRendered(true);
                    this.pollLstnr52.setRendered(true);
                    inPutPack(in1, in2, in3, in4);
                    myProcessingUnid5=proUid[u4];
                    this.workSt5Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                }
            }
            if (machines.length == z[m4]) {
                i = i + 1;
                noOfP1++;
                this.truck.setVisible(false);
                numberOfParts = String.valueOf(i);
                if (noOfP1 == (partsQty + 1)) {
                    this.clearWorkflowBinding.setDisabled(false);
                    this.startWorkflowBinding.setDisabled(false);
                    this.stopWFBinding.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(buttonContainerBinding);
                }
                
                if (i==4){
                    this.truck.setVisible(true);
                    i=0;
                    }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
            z[m4]++;
            m4++;
        }


    }

    public void workSt1PollLstnr42(PollEvent pollEvent) throws ParseException {
        String ref_id_new1 = "URL=" + next_url1[u4] + "&status=Processing";
        HttpRestClient httpRestClient1 = new HttpRestClient();
        httpRestClient1.connectToServer("http://" + urlValue + ":7077/callesbservice", "sendstatus");
        String jsonString1 = httpRestClient1.sendPOSTRequest(ref_id_new1);

        JSONParser parser1 = new JSONParser();

        JSONObject jsonObject1 = (JSONObject) parser1.parse(jsonString1);
        String message = (String) jsonObject1.get("SEND_CONFIRMATION");

        if (message != null) {
            this.workSt4Block.setInlineStyle("height:95px; width:95px;;background-color:Orange;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

        }
        this.pollLstnr42.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);


    }


    public void workSt1PollLstnr43(PollEvent pollEvent) throws ParseException {

        myProcessingUnid4=null;
        this.workSt4Block.setInlineStyle("height:95px; width:95px; background-color:#C0C0C0;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
        this.pollLstnr43.setRendered(false);
        this.upArrow4.setVisible(false);
        this.outParams4.setVisible(false);
        u4++;
        if (count4 < partsQty && machines[0].equalsIgnoreCase("Labelling")) {
            count4++;
            processUid=this.genProUid();
            String ref_id_new1 ="ID="+processUid +"&materialid="+mat_id;
            HttpRestClient httpRestClient = new HttpRestClient();
            httpRestClient.connectToServer("http://" + urlValue + ":7077/callesbservice", "startprocesswithrfid1");
            String jsonString = httpRestClient.sendPOSTRequest(ref_id_new1);

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            next_url1[u4] = (String) jsonObject.get("URL");
            proUid[u4]=(String)jsonObject.get("ID");
            ref_IdS12[u4]=proUid[u4];
            String status4 = (String) jsonObject.get("STATUS");
            System.out.println(" Value inside count4 for status is :" + next_url1[u4]);
            if (status4.contains("Process"))
                if (next_url1[u4] != null) {
                    this.pollLstnr41.setRendered(true);
                    this.pollLstnr42.setRendered(true);
                    inputP01 = (String) jsonObject.get("I_PARAM1");
                    inputP02 = (String) jsonObject.get("I_PARAM2");
                    inputP03 = (String) jsonObject.get("I_PARAM3");
                    inputP04 = (String) jsonObject.get("I_PARAM4");
                    inPutLabel(inputP01, inputP02, inputP03, inputP04);
                    myProcessingUnid4=proUid[u4];
                    this.workSt4Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
                    z[m4] = 1;
                    inv--;
                }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);

    }

    public void workSt1PollLstnr45(PollEvent pollEvent) {
        int randomTemp = (int) (Math.random() * (30 - 20) + 20);
        int randomHumid = (int) (Math.random() * (20 - 10) + 10);
        int randomPressure = (int) (Math.random() * (110 - 90) + 90);
        outTemp41 = "Temp:" + String.valueOf(randomTemp);
        outHumid41 = "Humid:" + String.valueOf(randomHumid);
        outRandomP4 = "Pressure:" + String.valueOf(randomPressure);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
    }
    
    public void workSt1PollLstnr46(PollEvent pollEvent) {
        if (countT41 == 10) {
            this.inParams4.setVisible(false);
            this.dnArrow4.setVisible(false);
            this.pollLstnr45.setRendered(true);
            this.upArrow4.setVisible(true);
            this.outTemp4.setVisible(true);
            this.pollLstnr46.setRendered(false);
            countT41 = 0;
            AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
        } else {
            countT41++;
        }

    }

    public void workSt1PollLstnr51(PollEvent pollEvent) throws IOException, InterruptedException, ParseException,
                                                               ClassNotFoundException {


        Calendar calobj = Calendar.getInstance();

        Date currentDate1 = calobj.getTime();

        if (tenSeconds5) {
            calobj.add(Calendar.SECOND, t5);
            dateAfterAdd5 = calobj.getTime();
            tenSeconds5 = false;
        }
        if (currentDate1.after(dateAfterAdd5)) {
            Runtime.getRuntime().exec("taskkill /IM AcroRd32.exe");
            this.workSt5Block.setInlineStyle("height:95px; width:95px; background-color:#B2FF66;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
            this.pollLstnr51.setRendered(false);
            this.pollLstnr53.setRendered(true);
            this.pollLstnr55.setRendered(false);
            this.outTemp5.setVisible(false);
            this.upArrow5.setVisible(false);
            myProcessingUnid5= null;
            tenSeconds5 = true;

            String ref_id_new1 =
                "URL=" + next_url1[u5] + "&wf_id=" + workFlowId + "&rf_id=" + ref_IdS12[u5] +
                "&q_param1=10&q_param2=5&q_param3=5&q_param4=0";
            HttpRestClient httpRestClient1 = new HttpRestClient();
            httpRestClient1.connectToServer("http://" + urlValue + ":7077/callesbservice", "sendqualityparameters");
            String jsonString1 = httpRestClient1.sendPOSTRequest(ref_id_new1);

            JSONParser parser1 = new JSONParser();

            JSONObject jsonObject1 = (JSONObject) parser1.parse(jsonString1);

            next_url1[u5] = (String) jsonObject1.get("next_url");
            String status1 = (String) jsonObject1.get("next_status");
            String in1 = (String) jsonObject1.get("next_param1");


            String in2 = (String) jsonObject1.get("next_param2");


            String in3 = (String) jsonObject1.get("next_param3");


            String in4 = (String) jsonObject1.get("next_param4");


            inputP54 = (String) jsonObject1.get("next_param4");
            System.out.println("Value of u5 :" + u5);
            System.out.println("Value of m5 :" + m5);
            System.out.println("value of z[m5] is" + z[m5]);
            System.out.println("Value of next_url1[u5]" + next_url1[u5]);
            if (status1.contains("Process") && z[m5] < machines.length) {
                outputP51 = "Dep:10";
                outputP52 = "Radi:5";
                outputP53 = "Stngth:5";
                outputP54 = "AvgTemp:2";
                this.outParams5.setVisible(true);
                this.upArrow5.setVisible(true);
                if (machines[z[m5]].equalsIgnoreCase("Turning")) {
                    this.pollLstnr21.setRendered(true);
                    this.pollLstnr22.setRendered(true);
                    inPutTurn(in1, in2, in3, in4);
                    myProcessingUnid2=proUid[u5];
                    this.workSt2Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                }


                else if (machines[z[m5]].equalsIgnoreCase("Painting")) {
                    this.pollLstnr31.setRendered(true);
                    this.pollLstnr32.setRendered(true);
                    inPutPaint(in1, in2, in3, in4);
                    myProcessingUnid3=proUid[u5];
                    this.workSt3Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                }

                else if (machines[z[m5]].equalsIgnoreCase("Labelling")) {
                    this.pollLstnr41.setRendered(true);
                    this.pollLstnr42.setRendered(true);
                    inPutLabel(in1, in2, in3, in4);
                    myProcessingUnid4=proUid[u5];
                    this.workSt4Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                } else if (machines[z[m5]].equalsIgnoreCase("Drilling")) {
                    this.pollLstnr11.setRendered(true);
                    this.pollLstnr12.setRendered(true);
                    inPutDrill(in1, in2, in3, in4);
                    myProcessingUnid1=proUid[u5];
                    this.workSt1Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

                }
            }
            if (machines.length == z[m5]) {
                i = i + 1;
                noOfP1++;
                this.truck.setVisible(false);
                numberOfParts = String.valueOf(i);
                if (noOfP1 == (partsQty + 1)) {
                    this.clearWorkflowBinding.setDisabled(false);
                    this.startWorkflowBinding.setDisabled(false);
                    this.stopWFBinding.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(buttonContainerBinding);
                }
                
                if (i==4){
                    this.truck.setVisible(true);
                    i=0;
                    }
            }
            z[m5]++;
            m5++;

            AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
        }


    }


    public void workSt1PollLstnr52(PollEvent pollEvent) throws ParseException {
        String ref_id_new1 = "URL=" + next_url1[u5] + "&status=Processing";
        HttpRestClient httpRestClient1 = new HttpRestClient();
        httpRestClient1.connectToServer("http://" + urlValue + ":7077/callesbservice", "sendstatus");
        String jsonString1 = httpRestClient1.sendPOSTRequest(ref_id_new1);

        JSONParser parser1 = new JSONParser();

        JSONObject jsonObject1 = (JSONObject) parser1.parse(jsonString1);
        String message = (String) jsonObject1.get("SEND_CONFIRMATION");

        if (message != null) {
            this.workSt5Block.setInlineStyle("height:95px; width:95px;;background-color:Orange;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");

        }
        this.pollLstnr52.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);


    }


    public void workSt1PollLstnr53(PollEvent pollEvent) throws ParseException {


        this.workSt5Block.setInlineStyle("height:95px; width:95px; background-color:#C0C0C0;border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
        this.pollLstnr53.setRendered(false);
        this.upArrow5.setVisible(false);
        this.outParams5.setVisible(false);
        u5++;
        if (count5 < partsQty && machines[0].equalsIgnoreCase("Packaging")) {
            count5++;
            processUid=this.genProUid();
            String ref_id_new1 ="ID="+processUid +"&materialid="+mat_id;
            HttpRestClient httpRestClient = new HttpRestClient();
            httpRestClient.connectToServer("http://" + urlValue + ":7077/callesbservice", "startprocesswithrfid1");
            String jsonString = httpRestClient.sendPOSTRequest(ref_id_new1);

            JSONParser parser = new JSONParser();

            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            next_url1[u5] = (String) jsonObject.get("URL");
            proUid[u5]=(String)jsonObject.get("ID");
            ref_IdS12[u5]=proUid[u5];
            String status5 = (String) jsonObject.get("STATUS");
            System.out.println(" Value inside count5 for status is :" + next_url1[u5]);
            if (status5.contains("Process")) {
                this.pollLstnr51.setRendered(true);
                this.pollLstnr52.setRendered(true);
                inputP01 = (String) jsonObject.get("I_PARAM1");
                inputP02 = (String) jsonObject.get("I_PARAM2");
                inputP03 = (String) jsonObject.get("I_PARAM3");
                inputP04 = (String) jsonObject.get("I_PARAM4");
                inPutPack(inputP01, inputP02, inputP03, inputP04);
                myProcessingUnid5=proUid[u5];
                this.workSt5Block.setInlineStyle("height:95px; width:95px; background-color:Yellow; border-radius:50% 50% 50% 50% / 50% 50% 50% 50%;font-size:large;");
                z[m5] = 1;
                inv--;
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);

    }

    public void workSt1PollLstnr55(PollEvent pollEvent) {
        int randomTemp = (int) (Math.random() * (30 - 20) + 20);
        int randomHumid = (int) (Math.random() * (20 - 10) + 10);
        int randomPressure = (int) (Math.random() * (110 - 90) + 90);
        outTemp51 = "Temp:" + String.valueOf(randomTemp);
        outHumid51 = "Humid:" + String.valueOf(randomHumid);
        outRandomP5 = "Pressure:" + String.valueOf(randomPressure);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
    }
    
    public void workSt1PollLstnr56(PollEvent pollEvent) {
        if (countT51 == 10) {
            this.inParams5.setVisible(false);
            this.dnArrow5.setVisible(false);
            this.pollLstnr55.setRendered(true);
            this.upArrow5.setVisible(true);
            this.outTemp5.setVisible(true);
            this.pollLstnr56.setRendered(false);
            countT51 = 0;
            AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
        } else {
            countT51++;
        }

    }


    public void addComponent(UIComponent parentUIComponent, UIComponent childUIComponent) {
        parentUIComponent.getChildren().add(childUIComponent);
        AdfFacesContext.getCurrentInstance().addPartialTarget(parentUIComponent);
    }


    public void clearWorkflow(ActionEvent actionEvent) {
        this.wsGrid11.setRendered(false);
        this.wsGrid12.setRendered(false);
        this.wsGrid13.setRendered(false);
        this.wsGrid21.setRendered(false);
        this.wsGrid22.setRendered(false);
        this.wsGrid23.setRendered(false);
        this.wsGrid31.setRendered(false);
        this.wsGrid32.setRendered(false);
        this.wsGrid33.setRendered(false);
        this.wsGrid41.setRendered(false);
        this.wsGrid42.setRendered(false);
        this.wsGrid43.setRendered(false);
        this.wsGrid51.setRendered(false);
        this.wsGrid52.setRendered(false);
        this.wsGrid53.setRendered(false);
        this.wsGrid01.setRendered(false);
        this.wsGrid02.setRendered(false);
        this.wsGrid03.setRendered(false);
        this.wsGrid61.setRendered(false);
        this.wsGrid62.setRendered(false);
        this.wsGrid63.setRendered(false);
        i = 0;
        numberOfParts = String.valueOf(i);
        this.loadWorkflowBinding.setDisabled(false);
        this.startWorkflowBinding.setDisabled(true);
        this.noOfP.setShowRequired(false);
        this.noOfP.setRequired(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelBox1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(buttonContainerBinding);
        HttpRestClient httpRestClient = new HttpRestClient();
        httpRestClient.connectToServer("http://" + urlValue + ":7077", "callesbservice");
        httpRestClient.sendPOSTRequest("");
    }


    public void connectToServer(String url, String operation) {
        try {
            restClient = (HttpURLConnection) (new URL(url + "/" + operation).openConnection());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendPOSTRequest(String requestParameter) {
        return sendRequest(requestParameter, POST);
    }

    public String sendRequest(String requestParameter, String requestMethod) {
        StringBuffer responseBuilder = new StringBuffer();
        try {
            restClient.setRequestMethod(requestMethod);
            restClient.setRequestProperty("User-Agent", "Mozilla/5.0");
            restClient.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            restClient.setDoOutput(true);
            DataOutputStream writerObject = new DataOutputStream(restClient.getOutputStream());
            writerObject.writeBytes(requestParameter);
            writerObject.flush();
            writerObject.close();

            Scanner scanResponse = new Scanner(restClient.getInputStream());
            while (scanResponse.hasNext()) {
                responseBuilder.append(scanResponse.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBuilder.toString();
    }

    public String sendGETRequest(String requestParameter) {

        return sendRequest(requestParameter, GET);
    }

    public void setRefIdBinding(RichInputText refIdBinding) {
        this.refIdBinding = refIdBinding;
    }

    public RichInputText getRefIdBinding() {
        return refIdBinding;
    }

    public void setWorkflowContainer(RichPanelGroupLayout workflowContainer) {
        this.workflowContainer = workflowContainer;
    }

    public RichPanelGroupLayout getWorkflowContainer() {
        return workflowContainer;
    }

    public void setStartWorkflowBinding(RichButton startWorkflowBinding) {
        this.startWorkflowBinding = startWorkflowBinding;
    }

    public RichButton getStartWorkflowBinding() {
        return startWorkflowBinding;
    }

    public void setClearWorkflowBinding(RichButton clearWorkflowBinding) {
        this.clearWorkflowBinding = clearWorkflowBinding;
    }

    public RichButton getClearWorkflowBinding() {
        return clearWorkflowBinding;
    }

    public void setLoadWorkflowBinding(RichButton loadWorkflowBinding) {
        this.loadWorkflowBinding = loadWorkflowBinding;
    }

    public RichButton getLoadWorkflowBinding() {
        return loadWorkflowBinding;
    }

    public void setButtonContainerBinding(RichPanelGroupLayout buttonContainerBinding) {
        this.buttonContainerBinding = buttonContainerBinding;
    }

    public RichPanelGroupLayout getButtonContainerBinding() {
        return buttonContainerBinding;
    }

    public void setWorkSt1Block(RichPanelBorderLayout workSt1Block) {
        this.workSt1Block = workSt1Block;
    }

    public RichPanelBorderLayout getWorkSt1Block() {
        return workSt1Block;
    }

    public void setWorkSt2Block(RichPanelBorderLayout workSt2Block) {
        this.workSt2Block = workSt2Block;
    }

    public RichPanelBorderLayout getWorkSt2Block() {
        return workSt2Block;
    }

    public void setWorkSt3Block(RichPanelBorderLayout workSt3Block) {
        this.workSt3Block = workSt3Block;
    }

    public RichPanelBorderLayout getWorkSt3Block() {
        return workSt3Block;
    }

    public void setWorkSt4Block(RichPanelBorderLayout workSt4Block) {
        this.workSt4Block = workSt4Block;
    }

    public RichPanelBorderLayout getWorkSt4Block() {
        return workSt4Block;
    }

    public void setWorkSt5Block(RichPanelBorderLayout workSt5Block) {
        this.workSt5Block = workSt5Block;
    }

    public RichPanelBorderLayout getWorkSt5Block() {
        return workSt5Block;
    }

    public void setDnArrow1(RichImage dnArrow1) {
        this.dnArrow1 = dnArrow1;
    }

    public RichImage getDnArrow1() {
        return dnArrow1;
    }

    public void setDnArrow2(RichImage dnArrow2) {
        this.dnArrow2 = dnArrow2;
    }

    public RichImage getDnArrow2() {
        return dnArrow2;
    }

    public void setDnArrow3(RichImage dnArrow3) {
        this.dnArrow3 = dnArrow3;
    }

    public RichImage getDnArrow3() {
        return dnArrow3;
    }

    public void setDnArrow4(RichImage dnArrow4) {
        this.dnArrow4 = dnArrow4;
    }

    public RichImage getDnArrow4() {
        return dnArrow4;
    }

    public void setDnArrow5(RichImage dnArrow5) {
        this.dnArrow5 = dnArrow5;
    }

    public RichImage getDnArrow5() {
        return dnArrow5;
    }

    public void setInParams1(RichPanelGroupLayout inParams1) {
        this.inParams1 = inParams1;
    }

    public RichPanelGroupLayout getInParams1() {
        return inParams1;
    }

    public void setInParams2(RichPanelGroupLayout inParams2) {
        this.inParams2 = inParams2;
    }

    public RichPanelGroupLayout getInParams2() {
        return inParams2;
    }

    public void setInParams3(RichPanelGroupLayout inParams3) {
        this.inParams3 = inParams3;
    }

    public RichPanelGroupLayout getInParams3() {
        return inParams3;
    }

    public void setInParams4(RichPanelGroupLayout inParams4) {
        this.inParams4 = inParams4;
    }

    public RichPanelGroupLayout getInParams4() {
        return inParams4;
    }

    public void setInParams5(RichPanelGroupLayout inParams5) {
        this.inParams5 = inParams5;
    }

    public RichPanelGroupLayout getInParams5() {
        return inParams5;
    }

    public void setUpArrow1(RichImage upArrow1) {
        this.upArrow1 = upArrow1;
    }

    public RichImage getUpArrow1() {
        return upArrow1;
    }

    public void setNumberOfParts(String numberOfParts) {
        this.numberOfParts = numberOfParts;
    }

    public String getNumberOfParts() {
        return numberOfParts;
    }

    public void setPartsProcessed(RichPanelGroupLayout partsProcessed) {
        this.partsProcessed = partsProcessed;
    }

    public RichPanelGroupLayout getPartsProcessed() {
        return partsProcessed;
    }

    public void setNumberOfPartsP(RichPanelLabelAndMessage numberOfPartsP) {
        this.numberOfPartsP = numberOfPartsP;
    }

    public RichPanelLabelAndMessage getNumberOfPartsP() {
        return numberOfPartsP;
    }

    public void setPanelBox1(RichPanelBox panelBox1) {
        this.panelBox1 = panelBox1;
    }

    public RichPanelBox getPanelBox1() {
        return panelBox1;
    }

    public void setEntry5(boolean entry5) {
        this.entry5 = entry5;
    }

    public boolean isEntry5() {
        return entry5;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void setUpArrow2(RichImage upArrow2) {
        this.upArrow2 = upArrow2;
    }

    public RichImage getUpArrow2() {
        return upArrow2;
    }

    public void setUpArrow3(RichImage upArrow3) {
        this.upArrow3 = upArrow3;
    }

    public RichImage getUpArrow3() {
        return upArrow3;
    }

    public void setUpArrow4(RichImage upArrow4) {
        this.upArrow4 = upArrow4;
    }

    public RichImage getUpArrow4() {
        return upArrow4;
    }

    public void setUpArrow5(RichImage upArrow5) {
        this.upArrow5 = upArrow5;
    }

    public RichImage getUpArrow5() {
        return upArrow5;
    }

    public void setOutParams1(RichPanelGroupLayout outParams1) {
        this.outParams1 = outParams1;
    }

    public RichPanelGroupLayout getOutParams1() {
        return outParams1;
    }

    public void setOutParams2(RichPanelGroupLayout outParams2) {
        this.outParams2 = outParams2;
    }

    public RichPanelGroupLayout getOutParams2() {
        return outParams2;
    }

    public void setOutParams3(RichPanelGroupLayout outParams3) {
        this.outParams3 = outParams3;
    }

    public RichPanelGroupLayout getOutParams3() {
        return outParams3;
    }

    public void setOutParams4(RichPanelGroupLayout outParams4) {
        this.outParams4 = outParams4;
    }

    public RichPanelGroupLayout getOutParams4() {
        return outParams4;
    }

    public void setOutParams5(RichPanelGroupLayout outParams5) {
        this.outParams5 = outParams5;
    }

    public RichPanelGroupLayout getOutParams5() {
        return outParams5;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setTruck(RichImage truck) {
        this.truck = truck;
    }

    public RichImage getTruck() {
        return truck;
    }

    public void setWorkstation4R(RichPanelBorderLayout workstation4R) {
        this.workstation4R = workstation4R;
    }

    public RichPanelBorderLayout getWorkstation4R() {
        return workstation4R;
    }

    public void setRejectedPartWS4(RichOutputText rejectedPartWS4) {
        this.rejectedPartWS4 = rejectedPartWS4;
    }

    public RichOutputText getRejectedPartWS4() {
        return rejectedPartWS4;
    }

    public void setInvCntWarnng(RichImage invCntWarnng) {
        this.invCntWarnng = invCntWarnng;
    }

    public RichImage getInvCntWarnng() {
        return invCntWarnng;
    }

    public void setInvntryCount(RichPanelLabelAndMessage invntryCount) {
        this.invntryCount = invntryCount;
    }

    public RichPanelLabelAndMessage getInvntryCount() {
        return invntryCount;
    }

    public void setInputP01(String inputP01) {
        this.inputP01 = inputP01;
    }

    public String getInputP01() {
        return inputP01;
    }

    public void setInputP02(String inputP02) {
        this.inputP02 = inputP02;
    }

    public String getInputP02() {
        return inputP02;
    }

    public void setInputP03(String inputP03) {
        this.inputP03 = inputP03;
    }

    public String getInputP03() {
        return inputP03;
    }

    public void setInputP04(String inputP04) {
        this.inputP04 = inputP04;
    }

    public String getInputP04() {
        return inputP04;
    }

    public void setInputP11(String inputP11) {
        this.inputP11 = inputP11;
    }

    public String getInputP11() {
        return inputP11;
    }

    public void setInputP12(String inputP12) {
        this.inputP12 = inputP12;
    }

    public String getInputP12() {
        return inputP12;
    }

    public void setInputP13(String inputP13) {
        this.inputP13 = inputP13;
    }

    public String getInputP13() {
        return inputP13;
    }

    public void setInputP14(String inputP14) {
        this.inputP14 = inputP14;
    }

    public String getInputP14() {
        return inputP14;
    }

    public void setOutputP11(String outputP11) {
        this.outputP11 = outputP11;
    }

    public String getOutputP11() {
        return outputP11;
    }

    public void setOutputP12(String outputP12) {
        this.outputP12 = outputP12;
    }

    public String getOutputP12() {
        return outputP12;
    }

    public void setOutputP13(String outputP13) {
        this.outputP13 = outputP13;
    }

    public String getOutputP13() {
        return outputP13;
    }

    public void setOutputP14(String outputP14) {
        this.outputP14 = outputP14;
    }

    public String getOutputP14() {
        return outputP14;
    }

    public void setMyProcessingUnid1(String myProcessingUnid1) {
        this.myProcessingUnid1 = myProcessingUnid1;
    }

    public String getMyProcessingUnid1() {
        return myProcessingUnid1;
    }

    public void setInputP21(String inputP21) {
        this.inputP21 = inputP21;
    }

    public String getInputP21() {
        return inputP21;
    }

    public void setInputP22(String inputP22) {
        this.inputP22 = inputP22;
    }

    public String getInputP22() {
        return inputP22;
    }

    public void setInputP23(String inputP23) {
        this.inputP23 = inputP23;
    }

    public String getInputP23() {
        return inputP23;
    }

    public void setInputP24(String inputP24) {
        this.inputP24 = inputP24;
    }

    public String getInputP24() {
        return inputP24;
    }

    public void setOutputP21(String outputP21) {
        this.outputP21 = outputP21;
    }

    public String getOutputP21() {
        return outputP21;
    }

    public void setOutputP22(String outputP22) {
        this.outputP22 = outputP22;
    }

    public String getOutputP22() {
        return outputP22;
    }

    public void setOutputP23(String outputP23) {
        this.outputP23 = outputP23;
    }

    public String getOutputP23() {
        return outputP23;
    }

    public void setOutputP24(String outputP24) {
        this.outputP24 = outputP24;
    }

    public String getOutputP24() {
        return outputP24;
    }

    public void setMyProcessingUnid2(String myProcessingUnid2) {
        this.myProcessingUnid2 = myProcessingUnid2;
    }

    public String getMyProcessingUnid2() {
        return myProcessingUnid2;
    }

    public void setInputP31(String inputP31) {
        this.inputP31 = inputP31;
    }

    public String getInputP31() {
        return inputP31;
    }

    public void setInputP32(String inputP32) {
        this.inputP32 = inputP32;
    }

    public String getInputP32() {
        return inputP32;
    }

    public void setInputP33(String inputP33) {
        this.inputP33 = inputP33;
    }

    public String getInputP33() {
        return inputP33;
    }

    public void setInputP34(String inputP34) {
        this.inputP34 = inputP34;
    }

    public String getInputP34() {
        return inputP34;
    }

    public void setOutputP31(String outputP31) {
        this.outputP31 = outputP31;
    }

    public String getOutputP31() {
        return outputP31;
    }

    public void setOutputP32(String outputP32) {
        this.outputP32 = outputP32;
    }

    public String getOutputP32() {
        return outputP32;
    }

    public void setOutputP33(String outputP33) {
        this.outputP33 = outputP33;
    }

    public String getOutputP33() {
        return outputP33;
    }

    public void setOutputP34(String outputP34) {
        this.outputP34 = outputP34;
    }

    public String getOutputP34() {
        return outputP34;
    }

    public void setMyProcessingUnid3(String myProcessingUnid3) {
        this.myProcessingUnid3 = myProcessingUnid3;
    }

    public String getMyProcessingUnid3() {
        return myProcessingUnid3;
    }

    public void setInputP41(String inputP41) {
        this.inputP41 = inputP41;
    }

    public String getInputP41() {
        return inputP41;
    }

    public void setInputP42(String inputP42) {
        this.inputP42 = inputP42;
    }

    public String getInputP42() {
        return inputP42;
    }

    public void setInputP43(String inputP43) {
        this.inputP43 = inputP43;
    }

    public String getInputP43() {
        return inputP43;
    }

    public void setInputP44(String inputP44) {
        this.inputP44 = inputP44;
    }

    public String getInputP44() {
        return inputP44;
    }

    public void setOutputP41(String outputP41) {
        this.outputP41 = outputP41;
    }

    public String getOutputP41() {
        return outputP41;
    }

    public void setOutputP42(String outputP42) {
        this.outputP42 = outputP42;
    }

    public String getOutputP42() {
        return outputP42;
    }

    public void setOutputP43(String outputP43) {
        this.outputP43 = outputP43;
    }

    public String getOutputP43() {
        return outputP43;
    }

    public void setOutputP44(String outputP44) {
        this.outputP44 = outputP44;
    }

    public String getOutputP44() {
        return outputP44;
    }

    public void setMyProcessingUnid4(String myProcessingUnid4) {
        this.myProcessingUnid4 = myProcessingUnid4;
    }

    public String getMyProcessingUnid4() {
        return myProcessingUnid4;
    }

    public void setInputP51(String inputP51) {
        this.inputP51 = inputP51;
    }

    public String getInputP51() {
        return inputP51;
    }

    public void setInputP52(String inputP52) {
        this.inputP52 = inputP52;
    }

    public String getInputP52() {
        return inputP52;
    }

    public void setInputP53(String inputP53) {
        this.inputP53 = inputP53;
    }

    public String getInputP53() {
        return inputP53;
    }

    public void setInputP54(String inputP54) {
        this.inputP54 = inputP54;
    }

    public String getInputP54() {
        return inputP54;
    }

    public void setOutputP51(String outputP51) {
        this.outputP51 = outputP51;
    }

    public String getOutputP51() {
        return outputP51;
    }

    public void setOutputP52(String outputP52) {
        this.outputP52 = outputP52;
    }

    public String getOutputP52() {
        return outputP52;
    }

    public void setOutputP53(String outputP53) {
        this.outputP53 = outputP53;
    }

    public String getOutputP53() {
        return outputP53;
    }

    public void setOutputP54(String outputP54) {
        this.outputP54 = outputP54;
    }

    public String getOutputP54() {
        return outputP54;
    }

    public void setMyProcessingUnid5(String myProcessingUnid5) {
        this.myProcessingUnid5 = myProcessingUnid5;
    }

    public String getMyProcessingUnid5() {
        return myProcessingUnid5;
    }

    public void setWsGrid11(RichGridCell wsGrid11) {
        this.wsGrid11 = wsGrid11;
    }

    public RichGridCell getWsGrid11() {
        return wsGrid11;
    }

    public void setWsGrid12(RichGridCell wsGrid12) {
        this.wsGrid12 = wsGrid12;
    }

    public RichGridCell getWsGrid12() {
        return wsGrid12;
    }

    public void setWsGrid13(RichGridCell wsGrid13) {
        this.wsGrid13 = wsGrid13;
    }

    public RichGridCell getWsGrid13() {
        return wsGrid13;
    }

    public void setWsGrid21(RichGridCell wsGrid21) {
        this.wsGrid21 = wsGrid21;
    }

    public RichGridCell getWsGrid21() {
        return wsGrid21;
    }

    public void setWsGrid22(RichGridCell wsGrid22) {
        this.wsGrid22 = wsGrid22;
    }

    public RichGridCell getWsGrid22() {
        return wsGrid22;
    }

    public void setWsGrid23(RichGridCell wsGrid23) {
        this.wsGrid23 = wsGrid23;
    }

    public RichGridCell getWsGrid23() {
        return wsGrid23;
    }

    public void setWsGrid31(RichGridCell wsGrid31) {
        this.wsGrid31 = wsGrid31;
    }

    public RichGridCell getWsGrid31() {
        return wsGrid31;
    }

    public void setWsGrid33(RichGridCell wsGrid33) {
        this.wsGrid33 = wsGrid33;
    }

    public RichGridCell getWsGrid33() {
        return wsGrid33;
    }

    public void setWsGrid41(RichGridCell wsGrid41) {
        this.wsGrid41 = wsGrid41;
    }

    public RichGridCell getWsGrid41() {
        return wsGrid41;
    }

    public void setWsGrid42(RichGridCell wsGrid42) {
        this.wsGrid42 = wsGrid42;
    }

    public RichGridCell getWsGrid42() {
        return wsGrid42;
    }

    public void setWsGrid43(RichGridCell wsGrid43) {
        this.wsGrid43 = wsGrid43;
    }

    public RichGridCell getWsGrid43() {
        return wsGrid43;
    }

    public void setWsGrid51(RichGridCell wsGrid51) {
        this.wsGrid51 = wsGrid51;
    }

    public RichGridCell getWsGrid51() {
        return wsGrid51;
    }

    public void setWsGrid52(RichGridCell wsGrid52) {
        this.wsGrid52 = wsGrid52;
    }

    public RichGridCell getWsGrid52() {
        return wsGrid52;
    }

    public void setWsGrid53(RichGridCell wsGrid53) {
        this.wsGrid53 = wsGrid53;
    }

    public RichGridCell getWsGrid53() {
        return wsGrid53;
    }

    public void setWsGrid32(RichGridCell wsGrid32) {
        this.wsGrid32 = wsGrid32;
    }

    public RichGridCell getWsGrid32() {
        return wsGrid32;
    }


    public void setWsGrid01(RichGridCell wsGrid01) {
        this.wsGrid01 = wsGrid01;
    }

    public RichGridCell getWsGrid01() {
        return wsGrid01;
    }

    public void setWsGrid02(RichGridCell wsGrid02) {
        this.wsGrid02 = wsGrid02;
    }

    public RichGridCell getWsGrid02() {
        return wsGrid02;
    }

    public void setOutRandomP1(String outRandomP1) {
        this.outRandomP1 = outRandomP1;
    }

    public String getOutRandomP1() {
        return outRandomP1;
    }

    public void setOutTemp21(String outTemp21) {
        this.outTemp21 = outTemp21;
    }

    public String getOutTemp21() {
        return outTemp21;
    }

    public void setOutHumid21(String outHumid21) {
        this.outHumid21 = outHumid21;
    }

    public String getOutHumid21() {
        return outHumid21;
    }

    public void setOutRandomP2(String outRandomP2) {
        this.outRandomP2 = outRandomP2;
    }

    public String getOutRandomP2() {
        return outRandomP2;
    }

    public void setWsGrid03(RichGridCell wsGrid03) {
        this.wsGrid03 = wsGrid03;
    }

    public RichGridCell getWsGrid03() {
        return wsGrid03;
    }

    public void setWsGrid61(RichGridCell wsGrid61) {
        this.wsGrid61 = wsGrid61;
    }

    public RichGridCell getWsGrid61() {
        return wsGrid61;
    }

    public void setWsGrid62(RichGridCell wsGrid62) {
        this.wsGrid62 = wsGrid62;
    }

    public RichGridCell getWsGrid62() {
        return wsGrid62;
    }

    public void setWsGrid63(RichGridCell wsGrid63) {
        this.wsGrid63 = wsGrid63;
    }

    public RichGridCell getWsGrid63() {
        return wsGrid63;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPollLstnr11(RichPoll pollLstnr11) {
        this.pollLstnr11 = pollLstnr11;
    }

    public RichPoll getPollLstnr11() {
        return pollLstnr11;
    }

    public void setPollLstnr12(RichPoll pollLstnr12) {
        this.pollLstnr12 = pollLstnr12;
    }

    public RichPoll getPollLstnr12() {
        return pollLstnr12;
    }

    public void setPollLstnr21(RichPoll pollLstnr21) {
        this.pollLstnr21 = pollLstnr21;
    }

    public RichPoll getPollLstnr21() {
        return pollLstnr21;
    }

    public void setPollLstnr22(RichPoll pollLstnr22) {
        this.pollLstnr22 = pollLstnr22;
    }

    public RichPoll getPollLstnr22() {
        return pollLstnr22;
    }

    public void setPollLstnr31(RichPoll pollLstnr31) {
        this.pollLstnr31 = pollLstnr31;
    }

    public RichPoll getPollLstnr31() {
        return pollLstnr31;
    }

    public void setPollLstnr32(RichPoll pollLstnr32) {
        this.pollLstnr32 = pollLstnr32;
    }

    public RichPoll getPollLstnr32() {
        return pollLstnr32;
    }

    public void setPollLstnr41(RichPoll pollLstnr41) {
        this.pollLstnr41 = pollLstnr41;
    }

    public RichPoll getPollLstnr41() {
        return pollLstnr41;
    }

    public void setPollLstnr42(RichPoll pollLstnr42) {
        this.pollLstnr42 = pollLstnr42;
    }

    public RichPoll getPollLstnr42() {
        return pollLstnr42;
    }

    public void setPollLstnr51(RichPoll pollLstnr51) {
        this.pollLstnr51 = pollLstnr51;
    }

    public RichPoll getPollLstnr51() {
        return pollLstnr51;
    }

    public void setPollLstnr52(RichPoll pollLstnr52) {
        this.pollLstnr52 = pollLstnr52;
    }

    public RichPoll getPollLstnr52() {
        return pollLstnr52;
    }

    public void setPollLstnr53(RichPoll pollLstnr53) {
        this.pollLstnr53 = pollLstnr53;
    }

    public RichPoll getPollLstnr53() {
        return pollLstnr53;
    }

    public void setPollLstnr13(RichPoll pollLstnr13) {
        this.pollLstnr13 = pollLstnr13;
    }

    public RichPoll getPollLstnr13() {
        return pollLstnr13;
    }

    public void setPollLstnr23(RichPoll pollLstnr23) {
        this.pollLstnr23 = pollLstnr23;
    }

    public RichPoll getPollLstnr23() {
        return pollLstnr23;
    }

    public void setPollLstnr33(RichPoll pollLstnr33) {
        this.pollLstnr33 = pollLstnr33;
    }

    public RichPoll getPollLstnr33() {
        return pollLstnr33;
    }

    public void setPollLstnr43(RichPoll pollLstnr43) {
        this.pollLstnr43 = pollLstnr43;
    }

    public RichPoll getPollLstnr43() {
        return pollLstnr43;
    }


    public void setPollLstnr24(RichPoll pollLstnr24) {
        this.pollLstnr24 = pollLstnr24;
    }

    public RichPoll getPollLstnr24() {
        return pollLstnr24;
    }

    public void setPollLstnr34(RichPoll pollLstnr34) {
        this.pollLstnr34 = pollLstnr34;
    }

    public RichPoll getPollLstnr34() {
        return pollLstnr34;
    }

    public void setPollLstnr44(RichPoll pollLstnr44) {
        this.pollLstnr44 = pollLstnr44;
    }

    public RichPoll getPollLstnr44() {
        return pollLstnr44;
    }

    public void setPollLstnr54(RichPoll pollLstnr54) {
        this.pollLstnr54 = pollLstnr54;
    }

    public RichPoll getPollLstnr54() {
        return pollLstnr54;
    }

    public void setPollLstnr15(RichPoll pollLstnr15) {
        this.pollLstnr15 = pollLstnr15;
    }

    public RichPoll getPollLstnr15() {
        return pollLstnr15;
    }

    public void setPollLstnr16(RichPoll pollLstnr16) {
        this.pollLstnr16 = pollLstnr16;
    }

    public RichPoll getPollLstnr16() {
        return pollLstnr16;
    }

    public void setOutTemp1(RichPanelGroupLayout outTemp1) {
        this.outTemp1 = outTemp1;
    }

    public RichPanelGroupLayout getOutTemp1() {
        return outTemp1;
    }

    public void setOutTemp11(String outTemp11) {
        this.outTemp11 = outTemp11;
    }

    public String getOutTemp11() {
        return outTemp11;
    }

    public void setOutHumid11(String outHumid11) {
        this.outHumid11 = outHumid11;
    }

    public String getOutHumid11() {
        return outHumid11;
    }

   

    public void setArrangeMachines(RichButton arrangeMachines) {
        this.arrangeMachines = arrangeMachines;
    }

    public RichButton getArrangeMachines() {
        return arrangeMachines;
    }

    public void setMachinesArranged(RichButton machinesArranged) {
        this.machinesArranged = machinesArranged;
    }

    public RichButton getMachinesArranged() {
        return machinesArranged;
    }

    public void setNoOfP(RichInputText noOfP) {
        this.noOfP = noOfP;
    }

    public RichInputText getNoOfP() {
        return noOfP;
    }

    public void setInv(int inv) {
        this.inv = inv;
    }

    public int getInv() {
        return inv;
    }

    public void setStopWFBinding(RichButton stopWFBinding) {
        this.stopWFBinding = stopWFBinding;
    }

    public RichButton getStopWFBinding() {
        return stopWFBinding;
    }


    public void setPollLstnr25(RichPoll pollLstnr25) {
        this.pollLstnr25 = pollLstnr25;
    }

    public RichPoll getPollLstnr25() {
        return pollLstnr25;
    }

    public void setPollLstnr26(RichPoll pollLstnr26) {
        this.pollLstnr26 = pollLstnr26;
    }

    public RichPoll getPollLstnr26() {
        return pollLstnr26;
    }

    public void setOutTemp2(RichPanelGroupLayout outTemp2) {
        this.outTemp2 = outTemp2;
    }

    public RichPanelGroupLayout getOutTemp2() {
        return outTemp2;
    }
    

    public void setOutTemp31(String outTemp31) {
        this.outTemp31 = outTemp31;
    }

    public String getOutTemp31() {
        return outTemp31;
    }

    public void setOutHumid31(String outHumid31) {
        this.outHumid31 = outHumid31;
    }

    public String getOutHumid31() {
        return outHumid31;
    }

    public void setOutRandomP3(String outRandomP3) {
        this.outRandomP3 = outRandomP3;
    }

    public String getOutRandomP3() {
        return outRandomP3;
    }

    public void setOutTemp3(RichPanelGroupLayout outTemp3) {
        this.outTemp3 = outTemp3;
    }

    public RichPanelGroupLayout getOutTemp3() {
        return outTemp3;
    }

    public void setPollLstnr35(RichPoll pollLstnr35) {
        this.pollLstnr35 = pollLstnr35;
    }

    public RichPoll getPollLstnr35() {
        return pollLstnr35;
    }

    public void setPollLstnr36(RichPoll pollLstnr36) {
        this.pollLstnr36 = pollLstnr36;
    }

    public RichPoll getPollLstnr36() {
        return pollLstnr36;
    }
    

    public void setOutTemp41(String outTemp41) {
        this.outTemp41 = outTemp41;
    }

    public String getOutTemp41() {
        return outTemp41;
    }

    public void setOutHumid41(String outHumid41) {
        this.outHumid41 = outHumid41;
    }

    public String getOutHumid41() {
        return outHumid41;
    }

    public void setOutRandomP4(String outRandomP4) {
        this.outRandomP4 = outRandomP4;
    }

    public String getOutRandomP4() {
        return outRandomP4;
    }

    public void setOutTemp4(RichPanelGroupLayout outTemp4) {
        this.outTemp4 = outTemp4;
    }

    public RichPanelGroupLayout getOutTemp4() {
        return outTemp4;
    }

    public void setPollLstnr45(RichPoll pollLstnr45) {
        this.pollLstnr45 = pollLstnr45;
    }

    public RichPoll getPollLstnr45() {
        return pollLstnr45;
    }

    public void setPollLstnr46(RichPoll pollLstnr46) {
        this.pollLstnr46 = pollLstnr46;
    }

    public RichPoll getPollLstnr46() {
        return pollLstnr46;
    }
    
    public void setOutTemp51(String outTemp51) {
        this.outTemp51 = outTemp51;
    }

    public String getOutTemp51() {
        return outTemp51;
    }

    public void setOutHumid51(String outHumid51) {
        this.outHumid51 = outHumid51;
    }

    public String getOutHumid51() {
        return outHumid51;
    }

    public void setOutRandomP5(String outRandomP5) {
        this.outRandomP5 = outRandomP5;
    }

    public String getOutRandomP5() {
        return outRandomP5;
    }

    public void setOutTemp5(RichPanelGroupLayout outTemp5) {
        this.outTemp5 = outTemp5;
    }

    public RichPanelGroupLayout getOutTemp5() {
        return outTemp5;
    }

    public void setPollLstnr55(RichPoll pollLstnr55) {
        this.pollLstnr55 = pollLstnr55;
    }

    public RichPoll getPollLstnr55() {
        return pollLstnr55;
    }

    public void setPollLstnr56(RichPoll pollLstnr56) {
        this.pollLstnr56 = pollLstnr56;
    }

    public RichPoll getPollLstnr56() {
        return pollLstnr56;
    }

    public void setRefIdBinding1(RichInputText refIdBinding1) {
        this.refIdBinding1 = refIdBinding1;
    }

    public RichInputText getRefIdBinding1() {
        return refIdBinding1;
    }
}

