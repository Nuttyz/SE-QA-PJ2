**Chosen Website** : [https://notebookspec.com/web/](https://notebookspec.com/web/)

**Reason**

We choose Notebookspec website because this website has many function that we can test on such as, searching, sorting, and comparing. Also, it is the website that we use often and have found bugs at some function.

**Note** : In the main function, we have set the precondition state of the website by opening the website then waiting for the popup to display and close it before beginning the testing processes.
___________________________________________________________________________________________________________________________________________________________________
**Test Case 1**

This test case checks the link whether it is going to right page or not. After the user clicks &quot;ติดต่อเรา&quot;, the website must show &quot;About us&quot; page and the current url must to same as About us url.

- **Steps**

  1. Navigate to home page
  2. click &quot;ติดต่อเรา&quot; link
  3. See the result, whether the current page show correctly or not

- **Expected result -** The &quot;ติดต่อเรา&quot; link is linking to About us page.
___________________________________________________________________________________________________________________________________________________________________
**Test Case 2**

This test case checks the link whether it is going to right page or not. After the user clicks &quot;ดูรุ่นทั้งหมด&quot;, the website must show &quot;Top chart notebook&quot; page and the current url must to same as Top Chart notebook url.

- **Steps**

  1. Navigate to home page
  2. click &quot;ดูรุ่นทั้งหมด&quot; link
  3. See the result, whether the current page show correctly or not

- **Expected result -** The &quot;ดูรุ่นทั้งหมด&quot; link is linking to About us page.
___________________________________________________________________________________________________________________________________________________________________
**Test Case 3**

This test case checks the link whether it is going to right page or not. After the user clicks &quot;บทความยอดนิยม&quot;, the website must show &quot;Tech news&quot; page and the current url must to same as Technews url.

- **Steps**

  1. Navigate to home page
  2. click &quot;บทความยอดนิยม&quot; link
  3. See the result, whether the current page show correctly or not

- **Expected result -** The &quot;บทความยอดนิยม&quot; link is linking to About us page.
___________________________________________________________________________________________________________________________________________________________________
**Test Case 4**

This test case checks the link whether it is going to right page or not. After the user clicks &quot;จัดสเปค&quot;, the website must show &quot;Spec PC&quot; page and the current url must to same as Spec PC url.

- **Steps**

  1. Navigate to home page
  2. click &quot;จัดสเปค&quot; link
  3. See the result, whether the current page show correctly or not

- **Expected result -** The &quot;จัดสเปค&quot; link is linking to About us page.
___________________________________________________________________________________________________________________________________________________________________
**Test Case 5**

This test case checks the sub-menu (filter options) on the notebook search page after the user clicks &quot;search for a gaming notebook &quot;. Therefore, the sub-menu on the left side of the results content must be updated. For example, the type of notebook must disappear since the user search for a gaming notebook.

- **Steps**

  1. Navigate to search page
  2. click &quot;ค้นหาโน้ตบุ๊คเล่นเกม&quot; (gaming notebook)
  3. See the result, which is the updated sub-menu on the left

- **Expected Output** - The filter menu of notebook type disappeared
___________________________________________________________________________________________________________________________________________________________________
**Test Case 6**

This test case checks for the sub-menu (filter options) on the notebook search page after the user clicks &quot;search for a gaming notebook &quot; and &quot;Price - ราคา&quot;. Therefore, the filter option of the notebook price must appear.

- **Steps**

  1. Navigate to search page
  2. click &quot;Type - ประเภทการใช้งาน&quot; to collapse the filter sub-menu
  3. click &quot;ค้นหาโน้ตบุ๊คเล่นเกม&quot; (gaming notebook)
  4. click &quot;Price - ราคา&quot; to expand the filter sub-menu
  5. See the result, whether the price filter sub-menu appear correctly or not

- **Expected Output** - The price filter sub-menu appear correctly (only one appeared sub-menu)
___________________________________________________________________________________________________________________________________________________________________
**Test Case 7**

The test case checks the result when the user searches the product by sending a query. It will check that the title of each product contains the query.

- **Steps**

  1. Navigate to search page
  2. Send a query into search input box

- **Expected Output** - All of the products that show contain the search query.
___________________________________________________________________________________________________________________________________________________________________
**Test Case 8**

This test case checks the result when user sorts the product by click dropdown and then click &quot;ราคาต่ำสุด&quot; the result must show the products that sorted form lowest price to highest price.

- **Steps**

  1. Navigate to search page
  2. click dropdown
  3. click &quot;ราคาต่ำสุด&quot;

- **Expected output -** All of the product are sorted by price from lowest to highest.
___________________________________________________________________________________________________________________________________________________________________
**Test Case 9**

This test case checks results of notebook comparison filter option, which is the highlighted function of the different spec of the compared notebook. Therefore, the different spec of compared notebooks must be highlighted correctly after the user clicked &quot;ไฮไลท์เฉพาะที่ต่างกัน&quot; (highlight only the differences).

- **Steps**

  1. Navigate to &quot;search for notebook&quot; page
  2. Click &quot;เปรียบเทียบ&quot; on the first two items in the search result items section
  3. Click submit the compare button to navigate to the notebook comparison page
  4. Switch the current tab to new opened tab and close the previous one
  5. Click &quot;ไฮไลท์เฉพาะที่ต่างกัน&quot; to highlight the different spec of compared notebook
  6. See the result, whether the differences are highlighted or not

- **Expected Output** - The different spec of compared notebooks is highlighted
___________________________________________________________________________________________________________________________________________________________________
**Test Case 10 - Content**

This test case checks the consistency of contents on the navigation bar on the top of the website. Therefore, the contents of the navigation bar must be the same.

- **Steps**

  1. Navigate to &quot;search for notebook&quot; page
  2. Find the elements of the notebook sub-menu, which are &quot;โน้ตบุ๊คเกมมิ่งส์&quot;, &quot;โน้ตบุ๊คใช้งานทั่วไป&quot;, and &quot;โน้ตบุ๊คบางเบา&quot;.
  3. See the result, whether the contents are identical with the other pages or not (have fixed values for checking)

- **Expected Output** - The contents in the sub-menu are identical
