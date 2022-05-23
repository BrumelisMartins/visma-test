class RecentlyUsedList(private val size: Int) {
    private val mItems = arrayListOf<String>()
    val items: List<String>
        get() = mItems

    fun add(item: String): Boolean {
        //returns a boolean if the adding operation was successful or not
        var success = false
        if (mItems.contains(item)) {
            mItems.remove(item)
            mItems.add(0, item)
            success = true
        } else if (mItems.size < size) {
            mItems.add(0, item)
            success = true
        }
        return success
    }
}