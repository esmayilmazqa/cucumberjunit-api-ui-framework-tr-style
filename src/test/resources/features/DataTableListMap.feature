Feature: Datatable kavramı üzerine List ve Map kavramlarını anlama

  Scenario: TC_001 Tek sutunluk DataTable nasil bir list olur?
    Then user controls one column datatable for List
      | id            |
      | code          |
      | startsAt      |
      | endsAt        |
      | numberOfUsers |
      | categories    |
      | discount      |
      | discountType  |

  @aaaaa
  Scenario: TC_002 Two sutunluk DataTable nasil bir list olur?
    Then user controls two column datatable for List
      | id       | numberOfUsers |
      | code     | categories    |
      | startsAt | discount      |
      | endsAt   | discountType  |

  Scenario: TC_003 Four sutunluk DataTable nasil bir list olur?
    Then user controls four column datatable for List
      | id   | numberOfUsers | startsAt | discount     |
      | code | categories    | endsAt   | discountType |

  Scenario: TC_004 Two sutunluk DataTable nasil bir map olur?
    Then user controls two column datatable for Map
      | id       | numberOfUsers |
      | code     | categories    |
      | startsAt | discount      |
      | endsAt   | discountType  |

  Scenario: TC_005 Two sutunluk DataTable nasil bir map olur?
    Then user controls two column and two row datatable for Map
      | id   | numberOfUsers |
      | code | categories    |

  Scenario: TC_006 Four sutunluk DataTable nasil bir map olur?
    Then user controls four column and two row datatable for Map
      | id   | numberOfUsers | startsAt | discount     |
      | code | categories    | endsAt   | discountType |

  Scenario: TC_007 Five sutunluk 4 satırlık Datatable nasıl bir map olur?
    Then user controls five column and four row datatable for Map
      | id           | numberOfUsers | startsAt | discount      |
      | code         | categories    | endsAt   | discountType  |
      | aaaaa        | bbbbb         | cccccc   | ddddddddddddd |
      | eeeeeeeeeeee | fffffff       | ggggg    | hhhhhhh       |

#  // List<String> newTable = dtable.asList(); -> tek listeye donusturemedi
#  //io.cucumber.datatable.UndefinedDataTableTypeException: Can't convert DataTable to List<java.lang.String>.
#  List<List<String>> twoColumn = dtable.asLists(String.class);
#  //[[id, numberOfUsers], [code, categories], [startsAt, discount], [endsAt, discountType]]
#  Map<String, String> mapTwoColumn = dtable.asMap();
#  //{id=numberOfUsers, code=categories, startsAt=discount, endsAt=discountType}
#  System.out.println(mapTwoColumn);