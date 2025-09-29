package com.susanto.beans;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;

import oracle.adf.view.rich.component.rich.nav.RichCommandMenuItem;

import oracle.adf.view.rich.component.rich.output.RichActiveOutputText;

import org.apache.myfaces.trinidad.util.ComponentReference;

public class LoginBean {
    private String decision;
    private ComponentReference utype;
    private ComponentReference uname;
    private ComponentReference pwd;
    FacesMessage infoMessage = null;
    private RichCommandMenuItem configureMachineBinding;
    private RichCommandMenuItem configureMacActionBinding;
    private static ADFLogger _logger = ADFLogger.createADFLogger(LoginBean.class);
    private RichPopup loginPopupBinding;

  public LoginBean() {

    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String doLoginDecision() {
        String admin_username = "Susanto";
        String user_username = "Nilesh";
        String admin_password = "welcome1";
        String user_password = "welcome2";
        String userType = (String) getUtype().getValue();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession httpSession = (HttpSession) externalContext.getSession(true);
        httpSession.setAttribute("uname", getUname().getValue());
        String userName = (String) getUname().getValue();
        String userPwd = (String) getPwd().getValue();

        if (userType.equals("Administrator")) {
            if (userName.equals(admin_username) && userPwd.equals(admin_password)) {
                _logger.info("Administrator login successful");
                return "gotoAdminBTF";
            } else {
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                this.getLoginPopupBinding().show(hints);
            }
        } else if (userType.equals("User")) {
            if (userName.equals(user_username) && userPwd.equals(user_password)) {
                _logger.info("User login successful");
                return "gotoUserBTF";
            } else {
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                this.getLoginPopupBinding().show(hints);
            }
        }
        return "";
    }

    public String getDecision() {
        return decision;
    }

    public void setUname(RichInputText uname) {
        this.uname = ComponentReference.newUIComponentReference(uname);

    }

    public RichInputText getUname() {
        return uname == null ? null : (RichInputText) uname.getComponent();
    }

    public void setPwd(RichInputText pwd) {
        this.pwd = ComponentReference.newUIComponentReference(pwd);

    }

    public RichInputText getPwd() {
        return pwd == null ? null : (RichInputText) pwd.getComponent();
    }

    public void setUtype(RichSelectOneRadio utype) {
        this.utype = ComponentReference.newUIComponentReference(utype);

    }

    public RichSelectOneRadio getUtype() {
        return utype == null ? null : (RichSelectOneRadio) utype.getComponent();
    }

    public void setConfigureMachineBinding(RichCommandMenuItem configureMachineBinding) {
        this.configureMachineBinding = configureMachineBinding;
    }

    public RichCommandMenuItem getConfigureMachineBinding() {
        return configureMachineBinding;
    }

    public void setConfigureMacActionBinding(RichCommandMenuItem configureMacActionBinding) {
        this.configureMacActionBinding = configureMacActionBinding;
    }

    public RichCommandMenuItem getConfigureMacActionBinding() {
        return configureMacActionBinding;
    }

    public void setLoginPopupBinding(RichPopup loginPopupBinding) {
        this.loginPopupBinding = loginPopupBinding;
    }

    public RichPopup getLoginPopupBinding() {
        return loginPopupBinding;
    }


}
