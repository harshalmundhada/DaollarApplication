# Coding Assignment for DAOFAB

API contracts

1) GET /getParent?sort=-id&page=2
    queryParams - 
    1. sort (String) -- sort by id
       "id" for sort with ascending order/ "-id" for descending order
    2. page (Integer) -- page no. you want to view
       page > 0 (note : will give empty json if the (page x limit) is greater than our Parent data size)
    3. limit (Integer) -- no. of items per page
       limit = 2, for this assignment
       
   eg - /getParent?sort=-id&page=2 -- for second page of the decreasing sort by id
                       
                       
2) GET /getChildTransactions/{parentId}
   pathVariale -
   1. parentId -- parent id for which we want all the child transactions
  
   eg - /getChildTransactions/2 -- List of all child transactions for parent id 2

