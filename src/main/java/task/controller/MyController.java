package task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import task.model.ChildView;
import task.model.Parent;
import task.model.ParentWithInstallmentView;
import task.service.Service;

@RestController
public class MyController {
    
    @GetMapping("/getParent")
	public List<ParentWithInstallmentView> getParent(@RequestParam("page") Optional<Integer> page, @RequestParam("limit") Optional<Integer> limit, @RequestParam("sort") Optional<String> sort) {
		Service s = new Service();
		List<Parent> list = s.getParent(page.orElse(1), limit.orElse(2), sort.orElse(""));        
		return s.getParentWithTotalPaid(list);
	}

	@GetMapping("/getChildTransactions/{parentId}")
	public List<ChildView> getChildTransactions(@PathVariable Long parentId) {
		Service s = new Service();
		List<ChildView> list = s.getChildWithParentId(parentId);
		return list;
	}
}
