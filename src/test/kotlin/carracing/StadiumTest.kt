package carracing

import io.kotest.matchers.shouldBe
import testFixture.OverFiveNumberGenerator
import testFixture.UnderFiveNumberGenerator
import kotlin.test.Test

class StadiumTest() {

    fun createStadium(
        cars: List<Car> = listOf(createCar(name = "또봇"), createCar(name = "석보드")),
        round: Int = 5
    ): Stadium {
        return Stadium(
            cars = cars,
            round = round
        )
    }

    @Test
    fun `스타디움은 자동차 리스트를 갖는다`() {
        val car1 = createCar("또봇")
        val car2 = createCar("석보드")

        val expectedCars = listOf(car1, car2)
        val stadium = createStadium()
        stadium.cars shouldBe expectedCars
    }

    @Test
    fun `스타디움은 총 이동 시도 횟수를 가진다`() {
        val car1 = createCar("또봇")
        val car2 = createCar("석보드")

        val round = 5
        val expectedCars = listOf(car1, car2)

        val stadium = Stadium(
            cars = expectedCars,
            round = round
        )
        stadium.round shouldBe round
    }

   @Test
   fun `스타디움은 각 자동차들에게 해당 회차 이동을 명령할 수 있다`() {
       // 반드시 움직이는 또봇
       val car1 = createCar(
           name = "또봇",
           numberGenerator = OverFiveNumberGenerator
       )
       // 반드시 움직이지 않는 석보드
       val car2 = createCar(
           name = "석보드",
           numberGenerator = UnderFiveNumberGenerator
       )
       val cars = listOf(car1, car2)
       val round = 5
       val stadium = createStadium(
           cars = cars,
           round = round
       )
       stadium.playRound()

       car1.position shouldBe 5
       car2.position shouldBe 0
   }

    @Test
    fun `스타디움은 자동차의 위치가 가장 큰 자동차를 우승자로 판단한다`() {
        // 반드시 움직이는 또봇
        val car1 = createCar(
            name = "또봇",
            numberGenerator = OverFiveNumberGenerator
        )
        // 반드시 움직이지 않는 석보드
        val car2 = createCar(
            name = "석보드",
            numberGenerator = UnderFiveNumberGenerator
        )

        val round = 5
        val expectedCars = listOf(car1, car2)

        val stadium = Stadium(
            cars = expectedCars,
            round = round
        )

        stadium.playRound()
        val winner = stadium.calculateWinner()

        winner shouldBe listOf(car1)
    }

    @Test
    fun `스타디움은 위치가 같은 자동차들은 공동 우승자로 판단한다`() {
        // 반드시 움직이는 또봇1
        val car1 = createCar(
            name = "또봇1",
            numberGenerator = OverFiveNumberGenerator
        )
        // 반드시 움직이는 또봇2
        val car2 = createCar(
            name = "또봇2",
            numberGenerator = OverFiveNumberGenerator
        )

        val round = 5
        val expectedCars = listOf(car1, car2)

        val stadium = Stadium(
            cars = expectedCars,
            round = round
        )

        stadium.playRound()
        val winners = stadium.calculateWinner()

        winners shouldBe listOf(car1, car2)
    }
}
