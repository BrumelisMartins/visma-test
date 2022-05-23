import org.junit.Assert
import org.junit.Test

class RecentlyUsedListTest {

    private lateinit var recentlyUsedList: RecentlyUsedList

    @Test
    fun testListSize() {
        val size = 5
        recentlyUsedList = RecentlyUsedList(size)
        for (item in 0..size) {
            if (item != size) {
                Assert.assertTrue("was not able to add item", recentlyUsedList.add(item.toString()))
            } else {
                //last item should not be added as the list is full
                Assert.assertFalse("was able to add item", recentlyUsedList.add(item.toString()))
            }
        }
        Assert.assertTrue("list size is incorrect size:${size}, listSize:${recentlyUsedList.items.size}", recentlyUsedList.items.size == size)
    }

    @Test
    fun testDuplicatesAndPosition() {
        recentlyUsedList = RecentlyUsedList(2)
        val firstItem = "URL1"
        val secondItem = "URL2"
        val firstPosition = 0
        val secondPosition = 1

        Assert.assertTrue("was not able to add item", recentlyUsedList.add(firstItem))
        Assert.assertTrue("was not able to add item", recentlyUsedList.add(secondItem))
        //check first item
        Assert.assertTrue("Item does not match position itemPosition = ${recentlyUsedList.items.indexOf(firstItem)}, testing position = $secondPosition", recentlyUsedList.items[secondPosition] == firstItem)
        //check second item
        Assert.assertTrue("Item does not match position itemPosition = ${recentlyUsedList.items.indexOf(secondItem)}, testing position = $firstPosition", recentlyUsedList.items[firstPosition] == secondItem)
        //add first item again and check if position has changed to first position
        Assert.assertTrue("was not able to add item", recentlyUsedList.add(firstItem))
        Assert.assertTrue("Item does not match position itemPosition = ${recentlyUsedList.items.indexOf(firstItem)}, testing position = $firstPosition", recentlyUsedList.items[firstPosition] == firstItem)
    }
}