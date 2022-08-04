package com.ksptooi.asf.core.entities;

public class CliCommandDefine {

    private String name;

    private CliParam[] params;

    public CliCommandDefine(String name){
        this.name = name;
        this.params = new CliParam[0];
    }

    public CliCommandDefine(String name,CliParam... params){
        this.name = name;
        this.params = params;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CliParam[] getParams() {
        return params;
    }

    public void setParams(CliParam[] params) {
        this.params = params;
    }
}
