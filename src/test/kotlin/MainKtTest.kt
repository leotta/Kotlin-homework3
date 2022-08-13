import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionVKPAYNormal() {
        val cardType = VKPAY
        val sumTransfer = 1_000
        val sumTransferMonth = 20_000

        val result = commissionAmount(cardType, sumTransferMonth,sumTransfer)

        assertEquals(0, result)
    }

    @Test
    fun commissionVKPAYLimitMonth() {
        val cardType = VKPAY
        val sumTransfer = 1_000
        val sumTransferMonth = 60_000

        val result = commissionAmount(cardType, sumTransferMonth,sumTransfer)

        assertEquals(-1, result)
    }

    @Test
    fun commissionVKPAYLimitTransfer() {
        val cardType = VKPAY
        val sumTransfer = 20_000
        val sumTransferMonth = 10_000

        val result = commissionAmount(cardType, sumTransferMonth,sumTransfer)

        assertEquals(-1, result)
    }

    @Test
    fun commissionMaestroNormal() {
        val cardType = MAESTRO
        val sumTransfer = 1_000
        val sumTransferMonth = 20_000

        val result = commissionAmount(cardType, sumTransferMonth,sumTransfer)

        assertEquals(26, result)
    }

    @Test
    fun commissionMaestroLimitMonth() {
        val cardType = MAESTRO
        val sumTransfer = 1_000
        val sumTransferMonth = 700_000

        val result = commissionAmount(cardType, sumTransferMonth,sumTransfer)

        assertEquals(-1, result)
    }

    @Test
    fun commissionMaestroLimitTransfer() {
        val cardType = MAESTRO
        val sumTransfer = 300_000
        val sumTransferMonth = 10_000

        val result = commissionAmount(cardType, sumTransferMonth,sumTransfer)

        assertEquals(-1, result)
    }

    @Test
    fun commissionVisaMinimal() {
        val cardType = VISA
        val sumTransfer = 1_000
        val sumTransferMonth = 20_000

        val result = commissionAmount(cardType, sumTransferMonth,sumTransfer)

        assertEquals(35, result)
    }

    @Test
    fun commissionVisaNormal() {
        val cardType = VISA
        val sumTransfer = 5_000
        val sumTransferMonth = 20_000

        val result = commissionAmount(cardType, sumTransferMonth,sumTransfer)

        assertEquals(57, result)
    }

    @Test
    fun commissionVisaLimitMonth() {
        val cardType = VISA
        val sumTransfer = 1_000
        val sumTransferMonth = 700_000

        val result = commissionAmount(cardType, sumTransferMonth,sumTransfer)

        assertEquals(-1, result)
    }

    @Test
    fun commissionVisaLimitTransfer() {
        val cardType = VISA
        val sumTransfer = 300_000
        val sumTransferMonth = 10_000

        val result = commissionAmount(cardType, sumTransferMonth,sumTransfer)

        assertEquals(-1, result)
    }

    @Test
    fun commissionWrongTypeCard() {
        val cardType = "Kiwi"
        val sumTransfer = 5_000
        val sumTransferMonth = 20_000

        val result = commissionAmount(cardType, sumTransferMonth,sumTransfer)

        assertEquals(0, result)
    }
}