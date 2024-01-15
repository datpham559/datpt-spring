package rest.dto;

public class ChatGPTResponse {
    String id;
    String object;
    int created;
    String model;
    ChatGPTResponseChoice[] choices;
    ChatGPTResponseUsage usage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ChatGPTResponseChoice[] getChoices() {
        return choices;
    }

    public void setChoices(ChatGPTResponseChoice[] choices) {
        this.choices = choices;
    }

    public ChatGPTResponseUsage getUsage() {
        return usage;
    }

    public void setUsage(ChatGPTResponseUsage usage) {
        this.usage = usage;
    }
}
