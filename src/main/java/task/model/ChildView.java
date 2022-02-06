package task.model;

public class ChildView extends Parent {

    private Long id;
    private String sender;
    private String receiver;
    private Integer totalAmount;
    private Integer paidAmount;
    
    public ChildView(Child relChild,Parent parent){
        this.id  = relChild.getId();
        this.sender  = parent.getSender();
        this.receiver  = parent.getReceiver();
        this.totalAmount  = parent.getTotalAmount();
        this.paidAmount  = relChild.getPaidAmount();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }
}
