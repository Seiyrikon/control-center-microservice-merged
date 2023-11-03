let datePickerCallBack = function datePickerCallBackHandler() {
  $('#startdate').datepicker({
    format: 'yyyy MM, dd',
  });   
  
  $('#enddate').datepicker({
    format: 'yyyy MM, dd',
  })
}