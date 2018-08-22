function choiceCategoryTC(category) {
    hiddenAllChoiceCategoryTC();
    switch (category) {
        case "1":
                $('#M').removeClass('hidden');
                break;
        case "2":
                $('#A').removeClass('hidden');
                break;
        case "3":
                $('#B').removeClass('hidden');
                break;
        case "4":
                $('#B1').removeClass('hidden');
                break;
        case "5":
                $('#C').removeClass('hidden');
                break;
        case "6":
                $('#C1').removeClass('hidden');
                break;
        case "7":
                $('#D').removeClass('hidden');
                break;
        case "8":
                $('#D1').removeClass('hidden');
                break;
        case "9":
                $('#BE').removeClass('hidden');
                break;
        case "10":
                $('#C1E').removeClass('hidden');
                break;
        case "11":
                $('#CE').removeClass('hidden');
                break;
        case "12":
                $('#D1E').removeClass('hidden');
                break;
        case "13":
                $('#DE').removeClass('hidden');
                break;

    }
}

function hiddenAllChoiceCategoryTC() {
    var classList = document.getElementsByClassName('choiceCategoryTC');
    $.each(classList, function(i, val) {
        $(val).addClass('hidden');
    });
}

function badDriver(button) {
        switch (button) {
            case "1":
                //$(val).prop("disabled", false);
                $('#dob').prop("disabled", false);
                $('#dol').prop("disabled", false);
                $('#yearOld').prop("disabled", false);
                $('#yearLicense').prop("disabled", false);
                break;
            case "0":
            case "2":
                $("#dob").prop("disabled", true);
                $('#yearOld').val(0);
                $('#yearOldView').val(0);
                $('#yearOld').prop("disabled", true);
                $("#dol").prop("disabled", true);
                $('#yearLicense').val(0);
                $('#yearLicenseView').val(0);
                $('#yearLicense').prop("disabled", true);
                break;
        }
}

// расчитывает количество полных лет между переданной датой и датой сегодняшней
function calculateExperience(id) {
    var today = new Date();
    var today_year = today.getFullYear();
    var today_month = today.getMonth();
    var today_day = today.getDate();
        
    var dob = new Date($('#'+id).val()); // получаем дату переданного элемента
    var dob_year = dob.getFullYear();
    var dob_month = dob.getMonth();
    var dob_day = dob.getDate();
    var i = today_year - dob_year; // количество полных лет
    if (today_year != dob_year) {
        if (today_month < dob_month) {
            i--;
        } else if (today_month == dob_month && today_day < dob_day) {
            i--;
        }
    }
    
    switch (id) {
        case "dob":
            $('#yearOld').val(i);
            $('#yearOldView').val(i);
            break;
        case "dol":
            $('#yearLicense').val(i);
            $('#yearLicenseView').val(i);
            break;
    }
    
}

function yearAutoDisabled(){
    $('#yearAuto').prop('disabled') ? $('#yearAuto').prop('disabled', false) : $('#yearAuto').prop('disabled', true);
    }
    
function powerAutoDisabled(){
    $('#powerAuto').prop('disabled') ? $('#powerAuto').prop('disabled', false) : $('#powerAuto').prop('disabled', true);
    }
    
function kbmDisabled(){
    $('#kbm').prop('disabled') ? $('#kbm').prop('disabled', false) : $('#kbm').prop('disabled', true);
    }