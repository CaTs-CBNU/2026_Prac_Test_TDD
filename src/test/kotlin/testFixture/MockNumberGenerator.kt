package testFixture

import util.NumberGenerator

object OverFiveNumberGenerator : NumberGenerator {
    override fun getNumber(): Int = 6
}

object UnderFiveNumberGenerator : NumberGenerator {
    override fun getNumber(): Int = 4
}