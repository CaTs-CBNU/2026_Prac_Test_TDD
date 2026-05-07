package carracing

import util.NumberGenerator

data class Car(
    val name: String,
    private val numberGenerator: NumberGenerator
) {
    init {
        require(name.length < 5) { throw IllegalArgumentException("이름은 5자를 넘을 수 없습니다.") }
    }

    var position: Int = 0

    fun move() {
        val number = numberGenerator.getNumber()
        if(number > 5) position++
    }


}