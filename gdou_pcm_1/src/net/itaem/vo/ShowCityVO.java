package net.itaem.vo;

import java.util.List;

public class ShowCityVO {
  private List<String> fromCity;
  private List<String> toCity;
  private List<String> team_name;
public List<String> getFromCity() {
	return fromCity;
}
public void setFromCity(List<String> fromCity) {
	this.fromCity = fromCity;
}
public List<String> getToCity() {
	return toCity;
}
public void setToCity(List<String> toCity) {
	this.toCity = toCity;
}
public List<String> getTeam_name() {
	return team_name;
}
public void setTeam_name(List<String> team_name) {
	this.team_name = team_name;
}
}
