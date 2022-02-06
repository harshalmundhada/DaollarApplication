package task.model;

public class Child {
    
    private Long id;
    private Long parentId;
    private Integer paidAmount;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getParentId() {
        return parentId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public Integer getPaidAmount() {
        return paidAmount;
    }
    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

}
