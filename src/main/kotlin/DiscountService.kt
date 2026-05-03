enum class MemberShipType(val discountAmount: Int) {
    FREE(0),
    STANDARD(3000),
}

class DiscountService {
    fun calculateDiscount(type: MemberShipType): Int {
        if (type == MemberShipType.FREE) {
            return type.discountAmount
        } else if (type == MemberShipType.STANDARD) {
            return type.discountAmount
        } else
            throw IllegalArgumentException("이상한 할인 타입 감지!")
    }
}
