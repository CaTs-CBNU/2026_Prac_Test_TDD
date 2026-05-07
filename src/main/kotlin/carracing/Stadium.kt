package carracing

class Stadium(val cars: List<Car>, val round: Int) {
    fun playRound() {
        repeat(round) {
            cars.forEach { car ->
                car.move()
            }
        }
    }

    fun calculateWinner(): List<Car> {
        val winner = cars.maxBy { it.position }
        val winners = cars.filter { it.position == winner.position }
        return winners
    }
}
