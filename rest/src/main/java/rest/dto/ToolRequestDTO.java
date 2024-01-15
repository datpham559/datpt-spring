package rest.dto;

public class ToolRequestDTO {
    private String path;

    private String inputElementId;
    private String inputElementClass;
    private String submitElementId;
    private String submitElementClass;
    private int countComment;
    private String cssInputElement;
    private String cssLikeElement;
    private String contentElement;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getInputElementId() {
        return inputElementId;
    }

    public void setInputElementId(String inputElementId) {
        this.inputElementId = inputElementId;
    }

    public String getInputElementClass() {
        return inputElementClass;
    }

    public void setInputElementClass(String inputElementClass) {
        this.inputElementClass = inputElementClass;
    }

    public int getCountComment() {
        return countComment;
    }

    public void setCountComment(int countComment) {
        this.countComment = countComment;
    }

    public String getSubmitElementId() {
        return submitElementId;
    }

    public void setSubmitElementId(String submitElementId) {
        this.submitElementId = submitElementId;
    }

    public String getSubmitElementClass() {
        return submitElementClass;
    }

    public void setSubmitElementClass(String submitElementClass) {
        this.submitElementClass = submitElementClass;
    }

    public String getCssInputElement() {
        return cssInputElement;
    }

    public void setCssInputElement(String cssInputElement) {
        this.cssInputElement = cssInputElement;
    }

    public String getCssLikeElement() {
        return cssLikeElement;
    }

    public void setCssLikeElement(String cssLikeElement) {
        this.cssLikeElement = cssLikeElement;
    }

    public String getContentElement() {
        return contentElement;
    }

    public void setContentElement(String contentElement) {
        this.contentElement = contentElement;
    }
}
