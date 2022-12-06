Feature: learn awesome data table

  Rule: concentrate, can get a bit complex

      Scenario: single row with no header
        Given my credentials
          | john | john213 |

    Scenario: multiple rows with no header
      Given many credentials
        | john | john213 |
        | doe  | doe213  |

    Scenario: single row with header
      Given credentials for single row with header
        | username | password |
        | john     | john213  |

    Scenario: multiple rows with header
      Given credentials for multiple rows with header
        | username | password |
        | john     | john123   |
        | bill     | bill123  |

    Scenario: row with header data table type
      Given credentials for row with header data table type
        | username | password |
        | john     | john123  |

    Scenario: multiple rows with header data table type
      Given credentials for multiple rows with header data table type
        | username | password |
        | john     | john123  |
        | bill     | bill123  |

    Scenario: single column with no header
      Given credentials for single column with no header
        | john    |
        | john123 |

    Scenario: single column with header
      Given credentials for single column with header
        | username | john    |
        | password | john123 |

    Scenario: single column with no header data table type
      Given credentials for single column with no header data table type
        | john    |
        | john123 |

    Scenario: single column with header data table type
      Given credentials for single column with header data table type
        | username | john    |
        | password | john123 |

    Scenario: multiple columns with header data table type
      Given my credentials for multiple columns with header data table type
        | username | john    | bill    |
        | password | john123 | bill123 |

