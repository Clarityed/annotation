/**
 * 这个函数用来证明 JavaScript 是动态语言
 */
function f() {
    var x = "var a = 3; var b = 5; alert(a + b)"
    // eval(x) 函数用来把字符串里面的语句解析成 js 脚本代码，并且执行，然后把结果赋值给 x
    // 这是在程序执行的时候可以改变 x 的类型
    eval(x);
}