### 解题思路
- `result * 10 + x % 10` 取出末位 `x % 10`（负数结果还是负数，无需关心正负），拼接到 `result` 中。
- `x / 10` 去除末位，`| 0` 强制转换为32位有符号整数。
- 通过 `| 0` 取整，无论正负，只移除小数点部分（正数向下取整，负数向上取整）。
- `result | 0` 超过32位的整数转换结果不等于自身，可用作溢出判断。

运算过程:
x | result
-- | -- 
123 | 0
12 | 3
1 | 32
0 | 321
### 代码

```javascript
/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let result = 0;
    while(x !== 0) {
        result = result * 10 + x % 10;
        x = (x / 10) | 0;
    }
    return (result | 0) === result ? result : 0;
};
```