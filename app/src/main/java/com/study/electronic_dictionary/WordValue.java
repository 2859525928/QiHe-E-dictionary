package com.study.electronic_dictionary;

import java.io.BufferedReader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;

public class WordValue implements Serializable, Comparable<WordValue> {
    public String word = null, psE = null, pronE = null, psA = null, pronA = null,
            interpret = null, sentOrig = null, sentTrans = null;//中文例句，英文例句


    public WordValue(String word, String psE, String pronE, String psA,
                     String pronA, String interpret, String sentOrig, String sentTrans) {
        super();
        this.word = "" + word;
        this.psE = "" + psE;
        this.pronE = "" + pronE;
        this.psA = "" + psA;
        this.pronA = "" + pronA;
        this.interpret = "" + interpret;
        this.sentOrig = "" + sentOrig;
        this.sentTrans = "" + sentTrans;
    }

    //防止空指针异常
    public WordValue() {
        super();
        this.word = "";
        this.psE = "";
        this.pronE = "";
        this.psA = "";
        this.pronA = "";
        this.interpret = "";
        this.sentOrig = "";
        this.sentTrans = "";


    }




    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPsE() {
        return psE;
    }

    public void setPsE(String psE) {
        this.psE = psE;
    }

    public String getPronE() {
        return pronE;
    }

    public void setPronE(String pronE) {
        this.pronE = pronE;
    }

    public String getPsA() {
        return psA;
    }

    public void setPsA(String psA) {
        this.psA = psA;
    }

    public String getPronA() {
        return pronA;
    }

    public void setPronA(String pronA) {
        this.pronA = pronA;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public String getSentOrig() {
        return sentOrig;
    }

    public void setSentOrig(String sentOrig) {
        this.sentOrig = sentOrig;
    }

    public String getSentTrans() {
        return sentTrans;
    }

    public void setSentTrans(String sentTrans) {
        this.sentTrans = sentTrans;
    }


    /**
     * 使得对象可以进行排序
     *
     * @param wordValue
     * @return
     */
    @Override
    public int compareTo(WordValue wordValue) {
        if (this.getWord().compareTo(wordValue.getWord()) > 0) {
            return 1;
        } else
            return -1;

    }
}
