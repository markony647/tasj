package helpers.todomvc;


public enum TaskType {
    ACTIVE("false"), COMPLETED("true");

    private String status;

    TaskType(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}


