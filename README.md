# RecyclerViewEnhanced
Android Library to provide swipe, click and other functionality to RecyclerView
## Usage

Add this to your build.gradle file

```
dependencies {
  compile 'com.nikhilpanju.recyclerviewenhanced:recyclerviewenhanced:1.0.0'
}
```
## Configuring
* #### Create an instance of `RecyclerTouchListener`
  `onTouchListener = new RecyclerTouchListener(this, mRecyclerView);`
  
* #### Set `IndependentViews` and `FadeViews` (If required)
  `IndependentViews` are views which can be clicked separately from the entire row. Their clicks have different functionality from row clicks. `FadeViews` are views which fade in and out as the rows are swiped closed and opened respectively.
  
  ```
  onTouchListener.setIndependentViews(R.id.rowButton)
                 .setViewsToFade(R.id.rowButton)               
  ```
  
* #### Implement `OnRowClickListener` using `setClickable()`
  `setClickable()` will enable clicks for the recycler view items and the `IndependentViews`
  
  ```
  .setClickable(new RecyclerTouchListener.OnRowClickListener() {
            @Override
            public void onRowClicked(int position) {
                // Do something
            }

            @Override
            public void onIndependentViewClicked(int independentViewID, int position) {
                // Do something
            }
        })               
  ```
* #### Enable Swipe Functionality
  Set the views for which you require a click listener and enable swiping by using `setSwipeable()`
  ```
  .setSwipeOptionViews(R.id.add, R.id.edit, R.id.change)
  .setSwipeable(R.id.rowFG, R.id.rowBG, new RecyclerTouchListener.OnSwipeOptionsClickListener() {
            @Override
            public void onSwipeOptionClicked(int viewID, int position) {
                if (viewID == R.id.add) {
                    // Do something
                } else if (viewID == R.id.edit) {
                    // Do something
                } else if (viewID == R.id.change) {
                    // Do something
                }
           }
       });
  ```
       
## Addition Functionality
* Use `setUnSwipeableRows()` to disable certain rows from swiping. Using this also displays an "difficult-to-slide" animation when trying to slide an unswipeable row.
* Use `setUnClickableRows()` to disable click actions for certain rows. (Note: This also prevents the independentViews from being clicked).
* `openSwipeOptions()` opens the swipe options for a specific row.
* `closeVisibleBG()` closes any open options.
* Implement `OnSwipeListener` to get `onSwipeOptionsClosed()` and `onSwipeOptionsOpened()` events.

  
### Closing swipe options when clicked anywhere outside of the recyclerView:
* Make your Activity implement `RecyclerTouchListener.RecyclerTouchListenerHelper` and store the touchListener
```
private OnActivityTouchListener touchListener;

@Override
public void setOnActivityTouchListener(OnActivityTouchListener listener) {
    this.touchListener = listener;
}
```
* Override `dispatchTouchEvent()` of your Activity and pass the `MotionEvent` variable to the `touchListener`
```
@Override
public boolean dispatchTouchEvent(MotionEvent ev) {
    if (touchListener != null) touchListener.getTouchCoordinates(ev);
        return super.dispatchTouchEvent(ev);
}
```
## Author
* Nikhil Panju ([Github](https://github.com/nikhilpanju))
