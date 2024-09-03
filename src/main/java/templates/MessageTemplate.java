package templates;

public class MessageTemplate {

    private String title;
    private String question;
    private String legend;
    private String yes;
    private String no;
    private String targetJspFile;

    public MessageTemplate() {
    }

    public MessageTemplate(String title, String question, String legend, String yes, String no, String targetJspFile) {
        this.title = title;
        this.question = question;
        this.legend = legend;
        this.yes = yes;
        this.no = no;
        this.targetJspFile = targetJspFile;
    }

    public MessageTemplate(String title, String question, String legend, String targetJspFile) {
        this.title = title;
        this.question = question;
        this.legend = legend;
        this.targetJspFile = targetJspFile;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }

    public String getTargetJspFile() {
        return targetJspFile;
    }

    public void setTargetJspFile(String targetJspFile) {
        this.targetJspFile = targetJspFile;
    }

    @Override
    public String toString() {
        return "Messages{ " +
                title + ", " +
                question + ", " +
                legend + ", " +
                yes + ", " +
                no +
                targetJspFile +
                " }";
    }

}
