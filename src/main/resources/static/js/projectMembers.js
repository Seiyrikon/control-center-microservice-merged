let projectMembersCallBack = function projectMembersCallBackHandler() {
    $(document).ready(function() {
      $('#projectMembers').DataTable({
        paging: true,
        searching: true,
        ordering: true,
        lengthMenu: [10, 25, 50, 100],
        pageLength: 10
      });
    });
  }