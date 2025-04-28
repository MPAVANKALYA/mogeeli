(function ($, Granite) {
    "use strict";

    $(document).on("foundation-contentloaded", function () {
        const modeSelector = $(".mode-selector coral-select");
        
        function toggleFields(value) {
            if (value === "manual") {
                $(".manual-field").removeClass("hide");
                $(".automation-field").addClass("hide");
            } else if (value === "automation") {
                $(".manual-field").addClass("hide");
                $(".automation-field").removeClass("hide");
            }
        }

        // Initial toggle on load
        toggleFields(modeSelector.val());

        // Change event for select field
        modeSelector.on("change", function () {
            toggleFields($(this).val());
        });
    });

})(jQuery, Granite);
