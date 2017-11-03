package user;

public class Course {
	private String name;
	private double credit;
	private int required;
	private String term;
	private int capacity;
	private int number;  //已选人数
	private String teacher;
	private String time;
	private String place;
	private String description;
	private double score;
	private int evaluateNum;
	private String evaluation;
	
	Course(String name,double credit,int required,String term,int capacity,int number,String teacher,String time,String place,String description,double score,int evaluateNum,String evaluation){
		this.setEvaluation(evaluation);
		this.setScore(score);
		this.setEvaluateNum(evaluateNum);
		this.capacity = capacity;
		this.number = number;
		this.credit = credit;
		this.time = time;
		this.place = place;
		this.description = description;
		this.name = name;
		this.required = required;
		this.term = term;
		this.teacher = teacher;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getNum() {
		return number;
	}
	public void setNum(int num) {
		this.number = num;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getDes() {
		return description;
	}
	public void setDes(String des) {
		this.description = des;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int isRequired() {
		return required;
	}
	public void setRequired(int required) {
		this.required = required;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getEvaluateNum() {
		return evaluateNum;
	}
	public void setEvaluateNum(int evaluateNum) {
		this.evaluateNum = evaluateNum;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

}
