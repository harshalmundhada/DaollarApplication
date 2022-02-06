package task.model;

public class ParentWithInstallmentView extends Parent {

    private Integer totalAmountPaid;
    
    public Integer getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(Integer totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public ParentWithInstallmentView(Parent parent, Integer totalAmountPaid){
        super(parent.getId(), parent.getSender(), parent.getReceiver(), parent.getTotalAmount());
        this.totalAmountPaid = totalAmountPaid;
    }
}
