如果右边的比左边的大，就加上两数之差；否则就只加上右边的数
```
func romanToInt(s string) int {

    var a,b byte
    nums := 0
    m := map[byte]int{
        'I' : 1, 'V' : 5, 'X' : 10, 'L' : 50, 'C' : 100, 'D' : 500, 'M' : 1000,
    }
    if len(s) == 0{
        return 0
    }
    if len(s) == 1{
        return m[byte(s[0])]
    }

    for i := 1; i < len(s); i++ {
        a = byte(s[len(s)-i])
        b = byte(s[len(s)-i-1])

        if m[a] > m[b]{
            nums = nums + (m[a] - m[b])
            i++
        }else{
            nums = nums + m[a]

        }
    
        if i == len(s)-1{
            nums = nums + m[byte(s[0])]
        }
    }

   
    return nums



}
```

