-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('评分模板定义', '2063', '1', 'template', 'scoring_template/template/index', 1, 0, 'C', '0', '0', 'scoring_template:template:list', '#', 'admin', sysdate(), '', null, '评分模板定义菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('评分模板定义查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'scoring_template:template:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('评分模板定义新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'scoring_template:template:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('评分模板定义修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'scoring_template:template:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('评分模板定义删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'scoring_template:template:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('评分模板定义导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'scoring_template:template:export',       '#', 'admin', sysdate(), '', null, '');