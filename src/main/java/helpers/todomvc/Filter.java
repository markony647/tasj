package helpers.todomvc;


public enum Filter {
    ALL(""),
    ACTIVE("active"),
    COMPLETED("completed");

    private String subUrl;

    Filter(String subUrl) {
        this.subUrl = subUrl;
    }

    public String getUrl() {
        return "https://todomvc4tasj.herokuapp.com/#/" + subUrl;
    }
}
