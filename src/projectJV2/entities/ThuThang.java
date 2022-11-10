package projectJV2.entities;

import java.util.Date;

public class ThuThang {
    public Integer id;
    public Integer roleId;
    public String role;
    public Integer income;
    public String date;

    public ThuThang(int id, String role, int income, Date date) {
    }

    public ThuThang(Integer id, Integer roleId, String role, Integer income, String date) {
        this.id = id;
        this.roleId = roleId;
        this.role = role;
        this.income = income;
        this.date = date;
    }

    public ThuThang(Integer id, String role, Integer income, String date) {
        this.id = id;
        this.role = role;
        this.income = income;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
