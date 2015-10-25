package com.saick.base.controller.requestobject;

import java.io.Serializable;

/**
 * @author Liubao
 * @version 2.0
 */
public class OrderCommitRequestHeader implements Serializable{
    private static final long serialVersionUID = -4723197208631580373L;
    
    private SaikeMobileHead saikemobilehead;
    
    public SaikeMobileHead getSaikemobilehead() {
        return saikemobilehead;
    }
    public void setSaikemobilehead(SaikeMobileHead saikemobilehead) {
        this.saikemobilehead = saikemobilehead;
    }

}
