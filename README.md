# springTransaction

1. When to use?
    1. It is used where there are multiple transactions, and we want either all of them to be completed or none
    2. Using @Transaction annotation on top of method will ensure that all the operations are either success or are
       rolled back in else scenario
2. 