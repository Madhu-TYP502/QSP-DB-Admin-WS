package com.flinko.listner.data.model;

import java.util.List;

public class Projects {

	private String projectName;

    private String projectId;

    private List<Scripts> scripts;

    public void setProjectName(String projectName){
        this.projectName = projectName;
    }
    public String getProjectName(){
        return this.projectName;
    }
    public void setProjectId(String projectId){
        this.projectId = projectId;
    }
    public String getProjectId(){
        return this.projectId;
    }
    public void setScripts(List<Scripts> scripts){
        this.scripts = scripts;
    }
    public List<Scripts> getScripts(){
        return this.scripts;
    }
}
