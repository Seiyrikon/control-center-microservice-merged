function getChipColor(member_name) {
    var hashCode = function(s) {
        return s.split('').reduce(function(a, b) {
            a = ((a << 5) - a) + b.charCodeAt(0);
            return a & a;
        }, 0);
    };
    var color = "#" + (hashCode(member_name) & 0x00FFFFFF).toString(16).toUpperCase();
    return color;
}
