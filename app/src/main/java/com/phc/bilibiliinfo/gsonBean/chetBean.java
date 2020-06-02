package com.phc.bilibiliinfo.gsonBean;

/**
 * 版权：没有版权 看得上就用
 *
 * @author peng
 * 创建日期：2020/6/1 23
 * 描述：
 */
public class chetBean {
    int chet ;
    String chetText ;


    /**
     *
     * @param chet chet type ==1 is seed  ==0 is accept
     * @param chetText
     */
    public chetBean(int chet, String chetText) {
        this.chet = chet;
        this.chetText = chetText;
    }

    public int getChet() {
        return chet;
    }

    public void setChet(int chet) {
        this.chet = chet;
    }

    public String getChetText() {
        return chetText;
    }

    public void setChetText(String chetText) {
        this.chetText = chetText;
    }
}
