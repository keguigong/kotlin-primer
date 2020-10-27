/**
 * 派生类初始化顺序
 * https://www.kotlincn.net/docs/reference/classes.html#%E6%B4%BE%E7%94%9F%E7%B1%BB%E5%88%9D%E5%A7%8B%E5%8C%96%E9%A1%BA%E5%BA%8F
 */
open class Base(val name: String) {

    init { println("Initializing Base") }

    open val size: Int =
            name.length.also { println("Initializing size in Base: $it") }
}

class Derived(
        name: String,
        val lastName: String,
) : Base(name.capitalize().also { println("Argument for Base: $it") }) {

    init { println("Initializing Derived") }

    override val size: Int =
            (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

/**
 * 调用超类实现
 * https://www.kotlincn.net/docs/reference/classes.html#%E8%B0%83%E7%94%A8%E8%B6%85%E7%B1%BB%E5%AE%9E%E7%8E%B0
 */
open class Rectangle {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}

/**
 * 接口中的属性
 * https://www.kotlincn.net/docs/reference/interfaces.html#%E6%8E%A5%E5%8F%A3%E4%B8%AD%E7%9A%84%E5%B1%9E%E6%80%A7
 */
interface MyInterface {
    val prop: Int // 抽象的

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}

class Child : MyInterface {
    override val prop: Int = 29
}


fun main() {
    val app = FilledRectangle()
    app.draw()
    println("Hello World!")
}