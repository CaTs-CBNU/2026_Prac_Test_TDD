import util.NumberGenerator

enum class MembershipType(val discountAmount: Int) {
    FREE(0),
    STANDARD(3000),
    PREMIUM(5000),
}

class DiscountService(private val numberGenerator: NumberGenerator) {
    fun calculateDiscount(type: MembershipType): Int {
        var totalDiscountAmount = 0
        totalDiscountAmount += membershipDiscount(membershipType = type)
        totalDiscountAmount += eventDiscount()

        return totalDiscountAmount
    }

    fun membershipDiscount(membershipType: MembershipType): Int {
        return when(membershipType) {
            MembershipType.FREE -> membershipType.discountAmount
            MembershipType.STANDARD -> membershipType.discountAmount
            MembershipType.PREMIUM -> membershipType.discountAmount
        }
    }

    fun eventDiscount(): Int {
        val number = numberGenerator.getNumber()

        return if (number > 5) 10_000
        else 0
    }
}
