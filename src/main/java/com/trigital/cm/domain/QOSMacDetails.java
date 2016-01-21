package com.trigital.cm.domain;

public class QOSMacDetails {
	
	private String sfid;
	private String dir;
	private String current_State;
	private String sid;
	private String sched_Type;
	private String prio;
	private String max_Sus_Rate;
	private String max_Brst;
	private String min_Rsv_Rate;
	private String through_put;
	
	
	
	public QOSMacDetails(String sfid, String dir, String current_State,
			String sid, String sched_Type, String prio,
			String max_Sus_Rate, String max_Brst, String min_Rsv_Rate,
			String through_put) {
		super();
		this.sfid = sfid;
		this.dir = dir;
		this.current_State = current_State;
		this.sid = sid;
		this.sched_Type = sched_Type;
		this.prio = prio;
		this.max_Sus_Rate = max_Sus_Rate;
		this.max_Brst = max_Brst;
		this.min_Rsv_Rate = min_Rsv_Rate;
		this.through_put = through_put;
	}
	
	public String getSfid() {
		return sfid;
	}
	public void setSfid(String sfid) {
		this.sfid = sfid;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getCurrent_State() {
		return current_State;
	}
	public void setCurrent_State(String current_State) {
		this.current_State = current_State;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSched_Type() {
		return sched_Type;
	}
	public void setSched_Type(String sched_Type) {
		this.sched_Type = sched_Type;
	}
	public String getPrio() {
		return prio;
	}
	public void setPrio(String prio) {
		this.prio = prio;
	}
	public String getMax_Sus_Rate() {
		return max_Sus_Rate;
	}
	public void setMax_Sus_Rate(String max_Sus_Rate) {
		this.max_Sus_Rate = max_Sus_Rate;
	}
	public String getMax_Brst() {
		return max_Brst;
	}
	public void setMax_Brst(String max_Brst) {
		this.max_Brst = max_Brst;
	}
	public String getMin_Rsv_Rate() {
		return min_Rsv_Rate;
	}
	public void setMin_Rsv_Rate(String min_Rsv_Rate) {
		this.min_Rsv_Rate = min_Rsv_Rate;
	}
	public String getThrough_put() {
		return through_put;
	}
	public void setThrough_put(String through_put) {
		this.through_put = through_put;
	}
	
	

}
