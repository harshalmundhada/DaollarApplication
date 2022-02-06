package task.service;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.util.StringUtils;

import task.model.Child;
import task.model.ChildView;
import task.model.Parent;
import task.model.ParentWithInstallmentView;
import task.persistance.DataStore;

public class Service {
    
    public List<ChildView> getChildWithParentId(Long parentId){
        Parent parent = DataStore.getParentById(parentId);
        List<Child> children = DataStore.getChildListFromFile();
        
        List<Child> relevantChildren = children.stream()
        .filter(c -> c.getParentId() == parent.getId())
        .collect(toList());
        
        List<ChildView> childView = new ArrayList<>();
        for(Child relChild : relevantChildren)
            childView.add(new ChildView(relChild,parent));
        return childView;
    }
    
    public List<Parent> getParent(int pagination, int limit, String sort){
            List<Parent> parents = DataStore.getParentListFromFile();
            
            if(!StringUtils.isEmpty(sort) && sort.contains("id")){
                    Comparator<Parent> compareById = (Parent p1, Parent p2) ->
                        p1.getId().compareTo( p2.getId() );
                    if(sort.toCharArray()[0] == '-')
                        Collections.sort(parents, compareById.reversed());
                    else
                        Collections.sort(parents, compareById);
            }
            
            List<Parent> pageParents = new ArrayList<>();
            if(parents.size() >= (limit-1)*pagination){
                int initIdx = Math.max(0,limit*pagination-limit);
                for(int i=0; i<limit && initIdx<parents.size(); i++,initIdx++){
                    pageParents.add(parents.get(initIdx));
                }
            }
            
            return pageParents;
                
    }
    
    public List<ParentWithInstallmentView> getParentWithTotalPaid(List<Parent> parents){
        List<Child> children = DataStore.getChildListFromFile();
        List<ParentWithInstallmentView> parentsTotalPaid = new ArrayList<>();
        for(Parent parent : parents){
            
            int sum = children.stream().filter(c -> c.getParentId()==parent.getId())
            .mapToInt(x -> x.getPaidAmount()).sum();
            
            parentsTotalPaid.add(new ParentWithInstallmentView(parent, sum));
        }
        return parentsTotalPaid;
    }
    
    
}
