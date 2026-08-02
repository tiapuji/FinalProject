Feature: Test Automation Rest Api

  @api
  Scenario: Successfully create new user
    Given prepare url valid for "CREATE_NEW_USER"
    And hit api post create new user
    Then validation status code equals 200
    Then validation response body create user
    Then validation response json with JSONSchema "post_create_user.json"

  @api
  Scenario: Successfully get list user by id
    Given prepare url valid for "GET_LIST_USER_BY_ID"
    And hit api get list user by id
    Then validation status code equals 200
    Then validation response body get list user by id
    Then validation response json with JSONSchema "get_list_user.json"

  @api
  Scenario: Successfully update existing user
    Given prepare url valid for "UPDATE_USER"
    And hit api update user
    Then validation status code equals 200
    Then validation response body update user
    Then validation response json with JSONSchema "update_user.json"

  @api
  Scenario: Successfully delete existing user
    Given prepare url valid for "DELETE_USER"
    And hit api delete user
    Then validation status code equals 200

  @api
  Scenario: Successfully get list tags
    Given prepare url valid for "GET_LIST_TAGS"
    And hit api get list tags
    Then validation status code equals 200
    Then validation response body get list tags
    Then validation response json with JSONSchema "get_list_tags.json"
