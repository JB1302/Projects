array = [1,2,3,4,5,6,7,8]

def first_non_consecutive(arr):
   
  for i in range(len(arr) -1):
       if (int(arr[i]) + 1 ) == int(arr[i+1]):
            pass
       else:
           return int(arr[i+1])
      


print(first_non_consecutive(array))