package carracing

import util.NumberGenerator
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import testFixture.OverFiveNumberGenerator
import kotlin.test.Test

fun createCar(
    name: String = "또봇",
    numberGenerator: NumberGenerator = OverFiveNumberGenerator,
): Car {
    return Car(
        name = name,
        numberGenerator = numberGenerator,
    )
}

class CarTest {

    @Test
    fun `자동차는 이름을 갖는다`() {
        val expectedName = "또봇"
        val car = createCar(expectedName)
        car.name shouldBe expectedName
    }

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val car = createCar()
        car.position shouldBe 0
    }

    @Test
    fun `자동차의 이름이 5자 초과라면 예외를 던진다`() {
        val longName = "또봇또봇또봇또봇또봇또봇또봇"

        shouldThrow<IllegalArgumentException> {
            val car = createCar(name = longName)
        }
    }

    @Test
    fun `자동차는 5이상의 숫자를 생성하면 position이 1 증가한다`() {
        val car = createCar(numberGenerator = OverFiveNumberGenerator)
        val previousPosition = car.position

        car.move()

        car.position shouldBe previousPosition + 1
    }
}
