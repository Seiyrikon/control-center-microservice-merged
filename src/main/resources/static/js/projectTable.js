$(document).ready(function() {
    $('#projectTable').DataTable({
      paging: true,
      searching: true,
      ordering: true,
      lengthMenu: [10, 25, 50, 100],
      pageLength: 10
    });
  });

