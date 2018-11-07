package tasks;

import java.util.ArrayList;

public class Department {
    /*
    info makes objects of position and employees of this position
    infoList creates a collection of employees who occupy one position
     */
    private Info info;
    private ArrayList<Info> infoList;

    public Department(Info info, ArrayList<Info> infoList) {
        this.info = info;
        this.infoList = infoList;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public ArrayList<Info> getInfoList() {
        return infoList;
    }

    public void setInfoList(ArrayList<Info> infoList) {
        this.infoList = infoList;
    }

    private class Info {
        /*
        position - position title(director/HR/etc)
        employee - collection of employees
         */
        private String position;
        private ArrayList<String> employee;

        private Info(String position, ArrayList<String> employee) {
            this.position = position;
            this.employee = employee;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public ArrayList<String> getEmployee() {
            return employee;
        }

        public void setEmployee(ArrayList<String> employee) {
            this.employee = employee;
        }
    }
}
