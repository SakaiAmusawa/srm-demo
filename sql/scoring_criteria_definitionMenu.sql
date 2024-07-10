-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商评分标准定义', '2063', '1', 'scoring_criteria_definition', 'supplier/scoring_criteria_definition/index', 1, 0, 'C', '0', '0', 'supplier:scoring_criteria_definition:list', '#', 'admin', sysdate(), '', null, '供应商评分标准定义菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商评分标准定义查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'supplier:scoring_criteria_definition:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商评分标准定义新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'supplier:scoring_criteria_definition:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商评分标准定义修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'supplier:scoring_criteria_definition:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商评分标准定义删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'supplier:scoring_criteria_definition:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商评分标准定义导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'supplier:scoring_criteria_definition:export',       '#', 'admin', sysdate(), '', null, '');